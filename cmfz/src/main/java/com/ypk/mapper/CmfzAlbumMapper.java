package com.ypk.mapper;

import com.ypk.entity.CmfzAlbum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
public interface CmfzAlbumMapper extends BaseMapper<CmfzAlbum> {
    List<CmfzAlbum> selectAlbumIdAndName(Integer size);
}
