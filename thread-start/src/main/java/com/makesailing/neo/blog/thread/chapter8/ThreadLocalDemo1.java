package com.makesailing.neo.blog.thread.chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/30 17:53
 */
public class ThreadLocalDemo1 {

    private static final int THREAD_POOL_SIZE = 2;
    /**
     * 3个 ThreadLocal
     */
    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal3 = new ThreadLocal<>();

    public static void main(String[] args) {
        // 线程池变量指定一个线程
        // 相当于 1个线程依附 3个 ThreadLocal
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.execute(() -> {
//            threadLocal1.set("123");
//            threadLocal2.set("456");
//            threadLocal3.set("789");
//            System.out.println(Thread.currentThread().getName());
//        });

        /**
         *  2个线程 3个对象
         *  从打印结果可以看出 ThreadLocalMap 是不同的
         */
//        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
//            executorService.execute(() -> {
//                threadLocal1.set("123");
//                threadLocal2.set("456");
//                threadLocal3.set("789");
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("threadLocal1 : " + threadLocal1.get());
//                System.out.println("threadLocal2 : " + threadLocal2.get());
//                System.out.println("threadLocal3 : " + threadLocal3.get());
//            });
//        }

        /**
         * 多个线程只设置一个 ThreadLocal
         * 从运行结果来看 : ThreadLocal的值会被覆盖掉
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 1000; i++) {
            int index = i;
            executorService.execute(() -> {
                threadLocal1.set(" 123 " + index);
                System.out.println(Thread.currentThread().getName());
                System.out.println("threadLocal1 : " + threadLocal1.get());
            });
        }


        executorService.shutdown();
    }
}
