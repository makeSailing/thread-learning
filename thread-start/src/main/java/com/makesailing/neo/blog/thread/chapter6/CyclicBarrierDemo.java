package com.makesailing.neo.blog.thread.chapter6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * # 例子 :
 * 	召唤神龙，需要7个法师去寻找龙珠，但这7个法师并不是一下子就能号召起来的，所以要等待召集齐7个法师，
 * 	然后在秋名山顶烧香拜佛为这7位法师送行，让他们同时出发，前往不同的地方寻找龙珠（敲黑板：这是第一个屏障点），
 * 	在这七位法师临行时约定找到龙珠之后还回到这个地方等待其他法师找到龙珠之后一起去见我。几年之后，第一个法师回来了，然后等待其他的法师。。
 * 	最后所有的法师全部到齐（敲黑板：这是第一个屏障点），然后组队来找我召唤神龙

 	从运行结果可以看出 : CyclicBarrier 不会阻塞主线程,但会阻塞子线程.
 *
 * @author jamie
 * @date 2018/12/28 17:30
 */
public class CyclicBarrierDemo {

	private static final int THREAD_COUNT_NUM = 7;

	public static void main(String[] args) {
		// 设置第一个屏障点,等待召集7位法师
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT_NUM, () -> {
			System.out.println("7个法师召集完毕，同时出发，去往不同地方寻找龙珠！");
			summonDragon();
		});

		// 召集7位法师
		for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
			int index = i;
			new Thread(()->{
				try {
					System.out.println("召集第 " + index + " 个法师");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

	/**
	 * 召唤神龙 1.收集龙珠 2.召唤神龙
	 */
	private static void summonDragon() {

		// 设置第二个屏障点,等待7位法师收集完7颗龙珠,召唤神龙
		final CyclicBarrier summonDragonBarrier = new CyclicBarrier(THREAD_COUNT_NUM, () -> {
			System.out.println("集齐七颗龙珠！召唤神龙！");
		});

		//收集7颗龙珠
		for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
			int index = i;
			new Thread(() -> {
				try {
					System.out.println("第 " + index + " 颗龙珠已收集到！");
					summonDragonBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}

	}
}


