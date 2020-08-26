package com.ypk.controller;


import com.ypk.common.annnotation.CmfzLogAnnotation;
import com.ypk.service.CmfzUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RequestMapping("/cmfz_user")
public class CmfzUserController {

    @Autowired
    private CmfzUserService cmfzUserService;

    @CmfzLogAnnotation(content = "查看用户信息统计",type = "select")
    @RequestMapping("selectAllSex")
    public Map selectAllSex() throws InterruptedException {
        Map map=new HashMap<>();
        map = cmfzUserService.selectSexDateAndProvince();
        return map;
    }

}
