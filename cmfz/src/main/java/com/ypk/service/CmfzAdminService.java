package com.ypk.service;

import com.ypk.entity.CmfzAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
public interface CmfzAdminService extends IService<CmfzAdmin> {
    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
       CmfzAdmin selectAdmin(String username,String password);
}
