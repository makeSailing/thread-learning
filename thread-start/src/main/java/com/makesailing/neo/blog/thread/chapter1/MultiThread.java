package com.makesailing.neo.blog.thread.chapter1;

import java.util.Objects;

/**
 * # 验证一个对象一把锁,多个线程多个锁 .
 *
 * @author jamie
 * @date 2018/12/27 14:12
 */
public class MultiThread {

	private int num = 200;

	public synchronized void printNum(String threadName, String tag) {
		if (Objects.equals(tag, "a")) {
			num = num - 100;
			System.out.println(threadName + " tag a ,set num over!");
		} else {
			num = num - 200;
			System.out.println(threadName + " tag b ,set num over!");
		}
		System.out.println(threadName + " tag : " + tag + " num : " + num);
	}

	public static void main(String[] args) {
		final MultiThread multiThread1 = new MultiThread();
		final MultiThread multiThread2 = new MultiThread();

		// 一个对象一把锁,多个线程多个锁

		new Thread(new Runnable() {
			@Override
			public void run() {
				multiThread1.printNum("thread1", "a");
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				multiThread2.printNum("thread2", "b");
			}
		}).start();

	}
}


