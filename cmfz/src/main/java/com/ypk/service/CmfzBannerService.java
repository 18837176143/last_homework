package com.ypk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypk.entity.CmfzBanner;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
public interface CmfzBannerService extends IService<CmfzBanner> {
         IPage<CmfzBanner> selectBanner(Integer begin,Integer end);
}
