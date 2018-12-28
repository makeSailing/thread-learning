package com.makesailing.neo.blog.thread.chapter5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * # ReentrantLock 实现线程间同步
 *
 * @author <a href="mailto:jamie.li@wolaidai.com">jamie.li</a>
 * @date 2018/12/28 15:24
 */
public class Run {

	public static void main(String[] args) {

		final Lock lock = new ReentrantLock();

		new Thread(() -> runMethond(lock), "t1").start();
		new Thread(() -> runMethond(lock), "t2").start();
		new Thread(() -> runMethond(lock), "t3").start();
		new Thread(() -> runMethond(lock), "t4").start();
		new Thread(() -> runMethond(lock), "t5").start();

	}

	private static void runMethond(Lock lock) {
		lock.lock();

		for (int i = 0; i < 5; i++) {
			System.out.println("ThreadName : " + Thread.currentThread().getName() + " i = " + i);
		}
		System.out.println("-----------------------");
		lock.unlock();
	}


}


