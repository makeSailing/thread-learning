package com.makesailing.neo.blog.thread.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * # 可以将任意对象作为监听器
 *
 * @author <a href="mailto:jamie.li@wolaidai.com">jamie.li</a>
 * @date 2018/12/27 16:06
 */
public class StringLock {

	private String lock = "lock";

	private void method() {
		synchronized (lock) {
			System.out.println("当前线程 : " + Thread.currentThread().getName() + " 开始");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前线程 : " + Thread.currentThread().getName() + " 结束");
		}
	}

	public static void main(String[] args) {
		final StringLock stringLock = new StringLock();
		new Thread(stringLock::method, "t1").start();
		new Thread(stringLock::method, "t2").start();
	}
}


