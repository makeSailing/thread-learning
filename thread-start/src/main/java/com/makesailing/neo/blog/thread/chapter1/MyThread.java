package com.makesailing.neo.blog.thread.chapter1;

/**
 * #
 *
 * @author <a href="mailto:jamie.li@wolaidai.com">jamie.li</a>
 * @date 2018/12/27 13:21
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("myThread 执行了 ...");
		}
	}

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start(); // 线程启动的方式
	}
}


