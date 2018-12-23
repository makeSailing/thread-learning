package com.makesailing.neo.mv.thread.t2;

/**
 * # 创建线程之 : 实现 Runnable接口
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/23 22:22
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("thread running ...");
        }
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();

        Thread thread = new Thread(demo2);

        thread.start();
    }
}
