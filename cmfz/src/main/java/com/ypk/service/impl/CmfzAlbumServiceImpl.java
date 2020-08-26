package com.ypk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypk.entity.CmfzAlbum;
import com.ypk.mapper.CmfzAlbumMapper;
import com.ypk.service.CmfzAlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@Service
public class CmfzAlbumServiceImpl extends ServiceImpl<CmfzAlbumMapper, CmfzAlbum> implements CmfzAlbumService {

    @Override
    public List<CmfzAlbum> selectAlbum() {
        return null;
    }

    @Override
    public List<CmfzAlbum> selectAlbumIdAndName(Integer size) {
        return baseMapper.selectAlbumIdAndName(size);


    }

    @Override
    public CmfzAlbum selectOneAlbum(Integer id) {
        return baseMapper.selectById(id);
    }
}
