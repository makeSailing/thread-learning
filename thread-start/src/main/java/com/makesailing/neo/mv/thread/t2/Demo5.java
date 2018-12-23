package com.makesailing.neo.mv.thread.t2;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * # 使用线程池创建线程
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/23 22:41
 */
public class Demo5 {

    public static void main(String[] args) {

        ExecutorService service = newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        service.shutdown();
    }
}
