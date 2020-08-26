package com.ypk.service;

import com.ypk.entity.CmfzAudio;
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
public interface CmfzAudioService extends IService<CmfzAudio> {
    List<CmfzAudio> selectAudio(Integer albumId);
}
