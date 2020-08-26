package com.ypk.mapper;

import com.ypk.entity.CmfzUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
public interface CmfzUserMapper extends BaseMapper<CmfzUser> {
       List<CmfzUser> selectAllSex();
       List<Map>selectSexNum();
       List<Map>selectTime();
       List<Map>selectProvince();
}
