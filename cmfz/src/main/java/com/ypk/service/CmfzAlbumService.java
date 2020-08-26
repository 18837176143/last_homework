package com.ypk.service;

import com.ypk.entity.CmfzAlbum;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
public interface CmfzAlbumService extends IService<CmfzAlbum> {
    /**
     *查询所有专辑
     * @return
     */
      List<CmfzAlbum> selectAlbum();

    /**
     * 查询最新的专辑
     * @param size 数目
     * @return
     */
      List<CmfzAlbum> selectAlbumIdAndName(Integer size);

      CmfzAlbum selectOneAlbum(Integer id);
}
