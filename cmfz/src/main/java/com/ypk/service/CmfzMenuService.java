package com.ypk.service;

import com.ypk.entity.CmfzMenu;
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
public interface CmfzMenuService extends IService<CmfzMenu> {
     List<CmfzMenu> selectAllMenu();
}
