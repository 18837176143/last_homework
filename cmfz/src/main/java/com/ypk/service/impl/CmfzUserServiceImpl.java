package com.ypk.service.impl;

import com.ypk.entity.CmfzUser;
import com.ypk.mapper.CmfzUserMapper;
import com.ypk.service.CmfzUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypk.common.util.ThreadPollUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@Service
public class CmfzUserServiceImpl extends ServiceImpl<CmfzUserMapper, CmfzUser> implements CmfzUserService {

    @Override
    public List<CmfzUser> selectAllSex() {
        return baseMapper.selectAllSex();
    }

    @Override
    public Map selectSexDateAndProvince() throws InterruptedException {
        Map map=new HashMap();
        CountDownLatch countDownLatch=new CountDownLatch(3);
        ThreadPoolExecutor executor = ThreadPollUtil.executor;
        executor.submit(() -> {
            map.put("sex",baseMapper.selectSexNum());
            countDownLatch.countDown();
        });
        executor.submit(()->{
            map.put("date",baseMapper.selectTime());
            countDownLatch.countDown();
        });
        executor.submit(()->{
            map.put("province",baseMapper.selectProvince());
            countDownLatch.countDown();
        });
        countDownLatch.await();
        return  map;
    }
}
