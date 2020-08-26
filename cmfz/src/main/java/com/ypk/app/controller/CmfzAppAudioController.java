package com.ypk.app.controller;

import com.ypk.app.R;
import com.ypk.common.ExceptionCodeEunm;
import com.ypk.service.CmfzAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Validated
@RequestMapping("/app/audio")
@RestController
public class CmfzAppAudioController {
   @Autowired
    private CmfzAudioService cmfzAudioService;

   @GetMapping("selectAudio/{albumId}")
    public R selectAudio(@PathVariable @NotNull(message = "专辑编号不能为空") Integer albumId){
       return R.ok(ExceptionCodeEunm.SUCCESS.getMsg())
               .put("data",cmfzAudioService.selectAudio(albumId))
               .put("code",ExceptionCodeEunm.SUCCESS.getCode());
   }
}
