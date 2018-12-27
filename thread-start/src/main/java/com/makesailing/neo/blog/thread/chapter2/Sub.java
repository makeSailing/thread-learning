package com.makesailing.neo.blog.thread.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁的 父子可继承性
 */
public class Sub extends Sup {

	 public synchronized void operateSubMethod() {
		try {
			while (i > 0) {
				i--;
				System.out.println("sub print i=" + i);
				TimeUnit.MILLISECONDS.sleep(100);
				this.operateSupMethod();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Thread(() -> {
			final Sub sub = new Sub();
			sub.operateSubMethod();
		}).start();
	}
}