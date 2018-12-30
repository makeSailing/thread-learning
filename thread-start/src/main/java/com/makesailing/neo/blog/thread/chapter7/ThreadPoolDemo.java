package com.makesailing.neo.blog.thread.chapter7;

import java.util.concurrent.*;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/30 15:13
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        /**
         * #  使用 Executors.newFixedThreadPool(4) 创建线程池,使用最新的阿里巴巴插件会出现
         * 以下提示 :
         * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，
         * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
         * 说明：Executors各个方法的弊端：
         *
         * 1）newFixedThreadPool和newSingleThreadExecutor:
         *   主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
         * 2）newCachedThreadPool和newScheduledThreadPool:
         *   主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
         */
//        ExecutorService executorService = Executors.newFixedThreadPool(4);

        /**
         * 遵循阿里巴巴提示,使用手动创建线程池
         *  参数说明 :
         *  corePoolSize : 核心线程池大小
         *  maximumPoolSize : 线程池最大容量大小
         *  keepAliveTime : 线程池空闲时,线程的存活时间
         *  TimeUnit : 时间单位
         *  BlockingQueue : 任务队列
         *  ThreadFactory : 线程工厂
         *  RejectedExecutionHandler : 线程拒绝策略
         */

        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> System.out.println("i : " + index + " executorService"));
        }

        executorService.shutdown();
    }
}
