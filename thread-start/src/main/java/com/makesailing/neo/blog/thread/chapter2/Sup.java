package com.makesailing.neo.blog.thread.chapter2;

import java.util.concurrent.TimeUnit;

public class Sup {

	public int i = 10;

	public synchronized void operateSupMethod() {
		i--;
		System.out.println("sup print i=" + i);
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
