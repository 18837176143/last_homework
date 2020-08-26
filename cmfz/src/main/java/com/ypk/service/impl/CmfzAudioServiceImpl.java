package com.ypk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypk.entity.CmfzAudio;
import com.ypk.mapper.CmfzAudioMapper;
import com.ypk.service.CmfzAudioService;
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
public class CmfzAudioServiceImpl extends ServiceImpl<CmfzAudioMapper, CmfzAudio> implements CmfzAudioService {


    @Override
    public List<CmfzAudio> selectAudio(Integer albumId) {
        return baseMapper.selectList(new QueryWrapper<CmfzAudio>().eq("album_id",albumId));
    }
}
