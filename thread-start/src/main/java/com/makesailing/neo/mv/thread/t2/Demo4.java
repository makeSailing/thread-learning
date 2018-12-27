package com.makesailing.neo.mv.thread.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * # 创建带有返回值的线程
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/23 22:35
 */
public class Demo4 implements Callable<Integer> {

    public static void main(String[] args) throws Exception {
        Demo4 demo4 = new Demo4();
        FutureTask<Integer> task = new FutureTask<Integer>(demo4);

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("我先干点别的哈 ...");

        Integer res = task.get();
        System.out.println("线程的执行结果为 : " + res);

    }

    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行紧张的计算 ...");
        TimeUnit.MILLISECONDS.sleep(100);
        return 0;
    }
}
