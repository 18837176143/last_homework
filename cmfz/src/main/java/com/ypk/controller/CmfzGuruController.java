package com.ypk.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ypk.entity.CmfzGuru;
import com.ypk.service.CmfzGuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.rmi.server.ExportException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@RestController
@RequestMapping("/cmfz_guru")
public class CmfzGuruController {

    @Autowired
    private CmfzGuruService cmfzGuruService;

    @RequestMapping("selectAllGuru")
    public Map<String,Object> selectAllGuru(Integer page,Integer limit){
        Map<String, Object>map=new HashMap<>();
        IPage<CmfzGuru> iPage = cmfzGuruService.selectAllByPage(page, limit);
        map.put("code",0);
        map.put("data",iPage.getRecords());
        map.put("count",iPage.getTotal());
        return map;
    }
    @RequestMapping("excelOut")
    public void excelOut(String s,HttpServletResponse response) throws IOException {
        response.setHeader("Context-Desposition","attachment;fileName=text.xls");
        response.setContentType("application/vnd.ms-excel");
        List<CmfzGuru> list = cmfzGuruService.list();
        for (CmfzGuru cmfzGuru : list) {
            System.out.println(cmfzGuru.getGuruImage());
            cmfzGuru.setGuruImage("http://localhost:8887/cmfz"+cmfzGuru.getGuruImage());
        }

        ExportParams exportParams=new ExportParams("所有上师数据","gurn");
        Workbook sheets = ExcelExportUtil.exportExcel(exportParams, CmfzGuru.class, list);

        sheets.write(response.getOutputStream());
    }
    @RequestMapping("inPort")
    public Map<String, Object> inPort(MultipartFile file) throws Exception {
        Map<String, Object> map=new HashMap<>();
        InputStream inputStream = file.getInputStream();
        ImportParams importParams=new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(1);
        List<CmfzGuru> list = ExcelImportUtil.importExcel(inputStream, CmfzGuru.class, importParams);
        for (CmfzGuru cmfzGuru : list) {
            String s=cmfzGuru.getGuruImage();
            String sub = StrUtil.sub(s, s.indexOf("\\img"), s.length());
             cmfzGuru.setGuruId(null);
             cmfzGuru.setGuruImage(sub);
        }
        cmfzGuruService.insertGuru(list);
        map.put("code",0);
        map.put("msg","导入成功");
        return map;
    }
}
