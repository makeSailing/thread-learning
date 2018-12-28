package com.makesailing.neo.blog.thread.chapter4;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * # 使用wait/notify模拟BlockingQueue阻塞队列
 * （1）初始化队列最大长度为5；
   （2）需要新加入的时候，判断是否长度为5，如果是5则等待插入；
   （3）需要消费元素的时候，判断是否为0，如果是0则等待消费；
 *
 * @author jamie
 * @date 2018/12/28 14:40
 */
public class MyQueue {

	// 1. 创建一个承接元素的集合
	private final LinkedList<Object> list = new LinkedList<>();

	// 2.定义个计数器
	private final AtomicInteger count = new AtomicInteger();

	// 3.指定上限与下限
	private final int maxSize = 5;
	private final int minSize = 0;

	// 4.初始化锁对象
	private static  final Object lock = new Object();

	public void put(Object obj) {
		synchronized (lock) {
			// 达到最大值无法添加,进行等待
			while (count.get() == maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 进行添加
			list.add(obj);
			count.getAndIncrement();
			System.out.println("元素 " + obj + "被添加");

			// 通知另一个阻塞的线程方法
			lock.notify();
		}
	}

	public void get() {
		Object temp;
		synchronized (lock) {
			// 达到最小,没有元素进行消费,进行等待
			while (count.get() == minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 进行消费
			count.getAndDecrement();
			temp = list.removeFirst();
			System.out.println("元素 " + temp + "被消费");

			lock.notify();
		}
	}

	private int size() {
		return count.get();
	}

	public static void main(String[] args) throws InterruptedException {
		final MyQueue myQueue = new MyQueue();
		initMyQueue(myQueue);

		final Thread t1 = new Thread(() -> {
			myQueue.put("h");
			myQueue.put("j");

		}, "t1");

		final Thread t3 = new Thread(() -> {
			myQueue.put("g");
			myQueue.put("h");

		}, "t3");

		Thread t2 = new Thread(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(200);
				// 如果注释掉正面这行,会出现死锁. 元素 size =5,锁对象一直处于等待的状态,没有人唤醒.
				// 其他的线程也进不来, t3 线程就是为了测试这情况
				// TODO 等待解决方案
				myQueue.get();
				TimeUnit.MILLISECONDS.sleep(200);
				myQueue.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t2");

		t1.start();
		TimeUnit.MILLISECONDS.sleep(1000);
		t2.start();

		TimeUnit.MILLISECONDS.sleep(2000);
		t3.start();



	}

	private static void initMyQueue(MyQueue myQueue) {
		myQueue.put("a");
		myQueue.put("b");
		myQueue.put("c");
		myQueue.put("d");
		myQueue.put("e");
		System.out.println("当前元素的个数 :　" + myQueue.size());
	}
}


