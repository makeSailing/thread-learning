package com.makesailing.neo.blog.thread.chapter1;

/**
 * #
 *
 * @author <a href="mailto:jamie.li@wolaidai.com">jamie.li</a>
 * @date 2018/12/27 13:55
 */
public class MyRunnable  implements Runnable {

	@Override
	public void run() {
		System.out.println("myrunnable 执行了 ...");
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}
}


