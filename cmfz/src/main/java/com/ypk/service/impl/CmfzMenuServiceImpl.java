package com.ypk.service.impl;

import com.ypk.entity.CmfzMenu;
import com.ypk.mapper.CmfzMenuMapper;
import com.ypk.service.CmfzMenuService;
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
public class CmfzMenuServiceImpl extends ServiceImpl<CmfzMenuMapper, CmfzMenu> implements CmfzMenuService {

    @Override
    public List<CmfzMenu> selectAllMenu() {
        return baseMapper.selectList(null);
    }
}
