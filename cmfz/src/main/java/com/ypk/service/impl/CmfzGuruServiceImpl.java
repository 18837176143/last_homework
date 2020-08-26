package com.ypk.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypk.entity.CmfzGuru;
import com.ypk.mapper.CmfzGuruMapper;
import com.ypk.service.CmfzGuruService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CmfzGuruServiceImpl extends ServiceImpl<CmfzGuruMapper, CmfzGuru> implements CmfzGuruService {

    @Override
    public IPage<CmfzGuru> selectAllByPage(Integer begin,Integer end) {
        Page<CmfzGuru>page=new Page<>(begin,end);
        log.debug("进来了");
        return baseMapper.selectPage(page,null);
    }

    @Override
    public void insertGuru(List<CmfzGuru> list) {
        for (CmfzGuru cmfzGuru : list) {
            baseMapper.insert(cmfzGuru);
        }

    }
}
