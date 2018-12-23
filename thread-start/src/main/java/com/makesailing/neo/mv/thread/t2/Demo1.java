package com.makesailing.neo.mv.thread.t2;

import java.util.concurrent.TimeUnit;

/**
 * # 创建线程之 : 继承 Thread类
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/23 21:52
 */
public class Demo1 extends Thread {

    public Demo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        //  demo1.interrupt(), 判断是否中断,中断了就不再执行
        while (!interrupted()) {
            System.out.println(getName() + "线程执行了...");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("first-thread");
        Demo1 demo2 = new Demo1("second-thread");

        demo1.start();
        demo2.start();

//        demo1.stop(); // stop 方法已经过时,不再采用,改用interrupt()
        demo1.interrupt();
    }
}
