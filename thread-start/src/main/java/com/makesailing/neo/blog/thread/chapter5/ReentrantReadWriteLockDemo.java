package com.makesailing.neo.blog.thread.chapter5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * # ReentrantLock具有完全排他的效果,即同一时间只能有一个线程进行执行ReentrantLock.lock之后的任务
 * ReentrantReadWriteLock 有两个锁: 读锁(共享锁),写锁(排他锁);
 * 特性: 读读共享 写写互斥 读写互斥 写读互斥
 *
 * @author <a href="mailto:jamie.li@wolaidai.com">jamie.li</a>
 * @date 2018/12/28 16:13
 */
public class ReentrantReadWriteLockDemo {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		final ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();

		// 读读共享 时间几乎相等
		//new Thread(() -> demo.read(), "t1").start();
		//new Thread(() -> demo.read(), "t2").start();

		// 写写互斥 时间差5s
		//new Thread(() -> demo.write(), "t3").start();
		//new Thread(() -> demo.write(), "t4").start();

		// 读写互斥 时间差5s
		new Thread(() -> demo.read(), "t3").start();
		new Thread(() -> demo.write(), "t4").start();

		// 写读互斥 时间差5s
		//new Thread(() -> demo.write(), "t3").start();
		//new Thread(() -> demo.read(), "t4").start();
	}

	private void read() {

		try {
			lock.readLock().lock();
			System.out.println("获取读锁 : " + Thread.currentThread().getName() + " 时间 : " + System.currentTimeMillis());
			// 模拟读操作时间 5s
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}

	}

	private void write() {

		try {
			lock.writeLock().lock();
			System.out.println("获取写锁 : " + Thread.currentThread().getName() + " 时间 : " + System.currentTimeMillis());
			// 模拟读操作时间 5s
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}

	}
}


