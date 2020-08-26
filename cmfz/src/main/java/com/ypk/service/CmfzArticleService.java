package com.ypk.service;

import com.ypk.entity.CmfzArticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
public interface CmfzArticleService extends IService<CmfzArticle> {

    CmfzArticle selectArticle(Integer id);
}
