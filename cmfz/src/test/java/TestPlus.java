import com.ypk.Application;
import com.ypk.app.R;
import com.ypk.entity.CmfzAlbum;
import com.ypk.entity.CmfzGuru;
import com.ypk.entity.CmfzMenu;
import com.ypk.service.CmfzAlbumService;
import com.ypk.service.CmfzGuruService;
import com.ypk.service.CmfzMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestPlus {

    @Autowired
    private CmfzAlbumService cmfzAlbumService;
    @Autowired
    private CmfzGuruService cmfzGuruService;

    @Autowired
    private CmfzMenuService cmfzMenuService;
    @Test
    public void  a1(){
        for (CmfzAlbum album : cmfzAlbumService.list()) {
            System.out.println(album);
        }
    }
    @Test
    public void  a2(){
        List<CmfzMenu> menus = cmfzMenuService.selectAllMenu();
        List<CmfzMenu> result=menus.stream()
                .filter(cmfzMenu -> {
                    return  cmfzMenu.getMenuParentId()==null;
                })
                .map(cmfzMenu -> {
                    cmfzMenu.setMenus(createMenuList(cmfzMenu,menus));
                    return cmfzMenu;
                })
                .collect(Collectors.toList());
        for (CmfzMenu cmfzMenu : result) {

            System.out.println(cmfzMenu);
        }
    }
    private List<CmfzMenu> createMenuList(CmfzMenu cmfzMenu,List<CmfzMenu> list){
        List li=list.stream()
                .filter(item->{
                    return   cmfzMenu.getMenuId().equals(item.getMenuParentId());
                })
                .collect(Collectors.toList());

        return  li;
    }


    @Test
    public void test3(){
        cmfzGuruService.selectAllByPage(1,3);
    }

    @Test
    public void test6(){
        R r=new R();
        System.out.println(r.get("msg"));
    }

    @Test
    public void test7(){
        List<CmfzAlbum> albums = cmfzAlbumService.selectAlbumIdAndName(4);
        for (CmfzAlbum album : albums) {
            System.out.println(album);
        }
    }
    @Test
    public void test8(){
    }
}
