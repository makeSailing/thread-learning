package com.makesailing.neo.mv.thread.t1;

import java.util.concurrent.TimeUnit;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/23 21:29
 */
public class NewThread implements Runnable {

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义的线程执行了...");
        }
    }

    public static void main(String[] args) {
//      初始化状态
        NewThread runnable = new NewThread();
        Thread thread = new Thread(runnable); // 创建线程,并指定任务
        thread.start(); //启动线程

        while (true) {
            synchronized (runnable) {
                System.out.println("主线程启动了....");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runnable.notifyAll();
            }
        }
    }
}
