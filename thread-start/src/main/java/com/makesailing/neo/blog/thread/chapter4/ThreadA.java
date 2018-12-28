package com.makesailing.neo.blog.thread.chapter4;

/**
 * #
 *
 * @author jamie
 * @date 2018/12/27 17:22
 */
public class ThreadA extends Thread {

	private Object lock;

	public ThreadA(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				if (MyList.size() != 5) {
					System.out.println("wait begin " + System.currentTimeMillis());
					lock.wait();
					System.out.println("waig end " + System.currentTimeMillis());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


