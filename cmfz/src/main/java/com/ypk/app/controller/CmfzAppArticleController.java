package com.ypk.app.controller;

import com.ypk.app.R;
import com.ypk.common.ExceptionCodeEunm;
import com.ypk.entity.CmfzArticle;
import com.ypk.service.CmfzArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/app/article")
public class CmfzAppArticleController {
   @Autowired
    private CmfzArticleService cmfzArticleService;

   @RequestMapping("selectArticle")
    public R selectArticle(@NotNull(message = "文章编号不能为空") Integer articleID){
       CmfzArticle article = cmfzArticleService.selectArticle(articleID);
       return  R.ok(ExceptionCodeEunm.SUCCESS.getMsg()).put("data",article).put("code",ExceptionCodeEunm.SUCCESS.getCode());
   }
}
