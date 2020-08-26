package com.ypk.common.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPollUtil {
    /**
     * 获取cpu的核心数  可以用来定义核心线程数
     */
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    /**
     * 手动通过 ThreadPoolExecutor 创建线程池
     *
     * corePoolSize 用于指定核心线程数量
     * maximumPoolSize 指定最大线程数
     * keepAliveTime指定线程空闲后的最大存活时间
     *
     * 可以根据项目的需要自定义线程池的参数
     */
    public static ThreadPoolExecutor executor  = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10l, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));
}
