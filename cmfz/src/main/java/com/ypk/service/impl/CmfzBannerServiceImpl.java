package com.ypk.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypk.entity.CmfzBanner;
import com.ypk.mapper.CmfzBannerMapper;
import com.ypk.service.CmfzBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@Service
public class CmfzBannerServiceImpl extends ServiceImpl<CmfzBannerMapper, CmfzBanner> implements CmfzBannerService {

    @Override
    public IPage<CmfzBanner> selectBanner(Integer begin, Integer end) {
        Page<CmfzBanner>page=new Page<>(begin,end);
        return baseMapper.selectPage(page,null);
    }
}
