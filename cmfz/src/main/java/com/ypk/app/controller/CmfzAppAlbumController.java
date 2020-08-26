package com.ypk.app.controller;

import com.ypk.app.R;
import com.ypk.common.ExceptionCodeEunm;
import com.ypk.entity.CmfzAlbum;
import com.ypk.service.CmfzAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RequestMapping("/app/album")
@RestController
public class CmfzAppAlbumController {
    @Autowired
    private CmfzAlbumService albumService;

        @GetMapping("selectAllAlbumIdAndName/{size}")
        public R selectAllAlbumIdAndName(@PathVariable @NotNull(message = "图片数量不能为空") Integer size){
        Map<String, Object> map=new HashMap<>();
        List<CmfzAlbum> albums = albumService.selectAlbumIdAndName(size);
        map.put("data",albums);
        map.put("code", ExceptionCodeEunm.SUCCESS.getCode());
        map.put("msg",ExceptionCodeEunm.SUCCESS.getMsg());
        return  R.ok(map);
    }
    @GetMapping("selectOneAlbum/{id}")
    public R selectOneAlbum(@PathVariable @NotNull(message = "专辑编号不能为空") Integer id){
            return R.ok(ExceptionCodeEunm.SUCCESS.getMsg())
                    .put("data",albumService.selectOneAlbum(id))
                    .put("code",ExceptionCodeEunm.SUCCESS.getCode());
    }

}
