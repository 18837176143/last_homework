package com.ypk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypk.entity.CmfzAdmin;
import com.ypk.mapper.CmfzAdminMapper;
import com.ypk.service.CmfzAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@Service
public class CmfzAdminServiceImpl extends ServiceImpl<CmfzAdminMapper, CmfzAdmin> implements CmfzAdminService {

    @Override
    public CmfzAdmin selectAdmin(String username, String password) {
        return baseMapper.selectOne(new QueryWrapper<CmfzAdmin>()
                .eq("username", username)
                .eq("password", password));
    }
}
