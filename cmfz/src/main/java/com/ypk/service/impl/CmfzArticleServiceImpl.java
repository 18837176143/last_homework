package com.ypk.service.impl;

import com.ypk.entity.CmfzArticle;
import com.ypk.mapper.CmfzArticleMapper;
import com.ypk.service.CmfzArticleService;
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
public class CmfzArticleServiceImpl extends ServiceImpl<CmfzArticleMapper, CmfzArticle> implements CmfzArticleService {

    @Override
    public CmfzArticle selectArticle(Integer id) {
        return baseMapper.selectById(id);
    }
}
