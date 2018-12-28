package com.makesailing.neo.blog.thread.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * #
 *
 * @author jamie
 * @date 2018/12/27 17:25
 */
public class ThreadB extends Thread {

	private Object lock;

	public ThreadB(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				MyList.add();
				if (MyList.size() == 5) {
					lock.notify();
					System.out.println("已经发出通知");
				}
				System.out.println("添加了 " + (i + 1) + "元素");
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


