import com.ypk.Application;
import com.ypk.entity.CmfzGuru;
import com.ypk.mapper.CmfzUserMapper;
import com.ypk.service.CmfzGuruService;
import com.ypk.common.util.GenerateUserUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestExcel {

    @Autowired
    private CmfzGuruService cmfzGuruService;
    @Test
    public void test() throws IOException, IllegalAccessException {
        List<CmfzGuru> list = cmfzGuruService.list();
        String[] s = {"上师编号", "上师名字", "上师图片地址", "上师法号", "上师状态"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("上师");
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < s.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(s[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            CmfzGuru cmfzGuru=list.get(i);
            Class<? extends CmfzGuru> aClass = cmfzGuru.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (int j=0;j<fields.length;j++) {
                Field field=fields[j];
                field.setAccessible(true);
                Object value=field.get(cmfzGuru);
                System.out.println(value);
                if (fields !=null){
                    if (value instanceof Integer){
                       row1.createCell(j).setCellValue((Integer)value);
                    }else {
                        row1.createCell(j).setCellValue(value.toString());
                    }
                }else {
                    row1.createCell(j).setCellValue("");
                }
            }
        }
        workbook.write(new FileOutputStream(("E://test2.xls")));
    }
    @Autowired
    private CmfzUserMapper cmfzUserMapper;
    @Test
    public void test2(){
        for(int i=0;i<100000;i++){
            cmfzUserMapper.insert(GenerateUserUtil.getUser());
        }
    }
}
