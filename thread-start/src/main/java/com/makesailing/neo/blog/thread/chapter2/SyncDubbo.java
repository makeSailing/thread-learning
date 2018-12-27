package com.makesailing.neo.blog.thread.chapter2;

/**
 * # Synchronized 锁重入
 *
 * @author <a href="mailto:jamie.li@wolaidai.com">jamie.li</a>
 * @date 2018/12/27 14:48
 */
public class SyncDubbo {

	public synchronized void method1() {
		System.out.println("method1 ...");
		method2();
	}

	public synchronized void method2() {
		System.out.println("method2 ...");
		method3();
	}

	public synchronized void method3() {
		System.out.println("method3 ...");
	}

	public static void main(String[] args) {
		final SyncDubbo dubbo = new SyncDubbo();
		new Thread(() -> dubbo.method1()).start();
	}

}


