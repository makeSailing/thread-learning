package com.makesailing.neo.blog.thread.chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * # 使用Lock对象和Condition实现等待/通知实例
 * 1. Object中wait()方法相当于Condition中的await()方法
 * 2. Object中的notify()方法相当于Condition中的signal()方法
 * 3. Object中notifyAll()方法相当于Condition中的signalAll()方法
 *
 * @author jamie
 * @date 2018/12/28 15:42
 */
public class LockConditionDemo {

	private static ReentrantLock lock = new ReentrantLock();

	private Condition condition = lock.newCondition();
	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		// 使用同一个LockCondition中的 lock,condition 一样
		final LockConditionDemo demo = new LockConditionDemo();
		//new Thread(() -> demo.await(),"t1").start();
		//TimeUnit.MILLISECONDS.sleep(1000);
		//new Thread(() -> demo.signal(),"t2").start();

		// 使用Lock对象和多个Condition实现等待/通知实例

		new Thread(() -> demo.await(demo.conditionA), "thread1_conditionA").start();
		new Thread(() -> demo.await(demo.conditionB), "thread2_conditionB").start();
		Thread.sleep(100);
		new Thread(() -> demo.signal(demo.conditionA), "thread3_conditionA").start();
		System.out.println("稍等5秒再通知其他的线程！");
		Thread.sleep(1000);
		new Thread(() -> demo.signal(demo.conditionB), "thread4_conditionB").start();


	}

	private void await() {
		try {
			lock.lock();
			System.out.println("开始等待 await! " + Thread.currentThread().getName());
			condition.await();
			System.out.println("等待 await 结束 " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void signal() {
		lock.lock();
		System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
		condition.signal();
		lock.unlock();
	}

	private void await(Condition condition) {
		try {
			lock.lock();
			System.out.println("开始等待 await! " + Thread.currentThread().getName());
			condition.await();
			System.out.println("等待 await 结束 " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void signal(Condition condition) {
		lock.lock();
		System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
		condition.signal();
		lock.unlock();
	}
}


