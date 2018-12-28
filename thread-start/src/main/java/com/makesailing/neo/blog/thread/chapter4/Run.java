package com.makesailing.neo.blog.thread.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * # wait 会释放锁, notify 不会释放锁
 *
 * @author jamie
 * @date 2018/12/27 17:28
 */
public class Run {

	public static void main(String[] args) {
		Object lock = new Object();
		final ThreadA threadA = new ThreadA(lock);
		threadA.start();
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		final ThreadB threadB = new ThreadB(lock);
		threadB.start();
	}
}


