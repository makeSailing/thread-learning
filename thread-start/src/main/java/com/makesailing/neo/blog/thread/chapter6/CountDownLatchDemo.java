package com.makesailing.neo.blog.thread.chapter6;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * # 举了例子：
 * <p>
 * 我们知道的集齐七颗龙珠就可以召唤神龙，那我们就一起召唤一下，下边我需要派7个人（7个线程）去分别去找这7颗不同的龙珠，
 * 每个人找到之后回来告诉我还需要等待的龙珠个数减1个，那么当全部的人都找到龙珠之后，那么我就可以召唤神龙了。
 * <p>
 * 1. 在每一个线程执行完毕之后,都需要执行CountDownLatch.countDown()方法,不能会出现死锁,一直处于等待
 * 2. 只有所有的线程都执行完毕之后,才会执行CountDownLatch.await()之后的代码
 * 3. 从运行结果可以看出CountDownLatch是会阻塞主线程的
 *
 * @author jamie
 * @date 2018/12/28 17:07
 */
public class CountDownLatchDemo {

    private static final Integer THREAD_COUNT_NUM = 7;

    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("第 " + index + " 个龙珠已收集到");
                    // 模拟收集第 i 个龙珠,随机模拟不同的寻找时间
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 每收集到一颗龙珠,需要等待的颗粒减 1
                countDownLatch.countDown(); // 注释此代码,会出现死锁
            }).start();
        }

        // 等待检查,即上述7个线程执行完毕后,执行await后的代码
        // 会阻塞主线程
        countDownLatch.await();

        System.out.println("集齐七颗龙珠! 召唤神龙");
    }
}


