package com.ypk.service;

import com.ypk.entity.CmfzUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
public interface CmfzUserService extends IService<CmfzUser> {
    List<CmfzUser> selectAllSex();
    Map selectSexDateAndProvince() throws InterruptedException;
}
