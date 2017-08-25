package com.funkyer.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liushi on 17/8/25.
 */
public class ThreadUtils
{
    /**
     * 执行线程数量
     */
    private int executorThreadCount = 20;//默认20

    private int corePoolSize = executorThreadCount;
    private int maximumPoolSize = 10000;
    private int keepAliveTime = 60*3;
    private long milliseconds;

    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(32));

    public void execute(Runnable task)
    {
        poolExecutor.execute(task);
    }
}
