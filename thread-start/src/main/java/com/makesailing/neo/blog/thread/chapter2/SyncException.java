package com.makesailing.neo.blog.thread.chapter2;

/**
 * # Synchronized 出现异常时,锁会自动释放
 *
 * @author <a href="mailto:jamie.li@wolaidai.com">jamie.li</a>
 * @date 2018/12/27 15:55
 */
public class SyncException {

	private int a = 0;

	private synchronized void operation() {
		while (true) {
			a++;
			System.out.println(Thread.currentThread().getName() + " , i = " + a);
			if (a == 10) {
				Integer.parseInt("b");
			}
		}
	}

	public static void main(String[] args) {
		final SyncException sync = new SyncException();
		new Thread(() -> sync.operation()).start();
	}
}


