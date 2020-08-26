package com.ypk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypk.entity.CmfzGuru;
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
public interface CmfzGuruService extends IService<CmfzGuru> {
       IPage<CmfzGuru> selectAllByPage(Integer begin,Integer end);
       void insertGuru(List<CmfzGuru> list);
}
