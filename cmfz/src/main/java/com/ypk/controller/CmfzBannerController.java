package com.ypk.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ypk.common.annnotation.CmfzLogAnnotation;
import com.ypk.entity.CmfzBanner;
import com.ypk.service.CmfzBannerService;
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
@RequestMapping("/cmfz_banner")
public class CmfzBannerController {
    @Autowired
    private CmfzBannerService cmfzBannerService;

    @CmfzLogAnnotation(content = "查看轮播图信息",type = "select")
    @RequestMapping("selectBanner")
    public Map<String, Object> selectBanner(Integer page,Integer limit){
        Map<String, Object> map=new HashMap<>();
        IPage<CmfzBanner> iPage = cmfzBannerService.selectBanner(page, limit);
        map.put("code",0);
        map.put("data",iPage.getRecords());
        map.put("count",iPage.getTotal());
        return map;
    }

}
