package com.makesailing.neo.blog.thread.chapter1;

/**
 * #
 *
 * @author jamie
 * @date 2018/12/27 14:01
 */
public class Demo1 extends Thread {

	private int count = 10;

	@Override
	public synchronized void run() { // 使用synchronized 修改方式,锁住对象,每次只能一个进入,其他排斥在外面
		count--;
		System.out.println(currentThread().getName() + " count : " + count);
	}

	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		Thread t1 = new Thread(demo1, "t1");
		Thread t2 = new Thread(demo1, "t2");
		Thread t3 = new Thread(demo1, "t3");
		Thread t4 = new Thread(demo1, "t4");
		Thread t5 = new Thread(demo1, "t5");
		Thread t6 = new Thread(demo1, "t6");
		Thread t7 = new Thread(demo1, "t7");
		Thread t8 = new Thread(demo1, "t8");
		Thread t9 = new Thread(demo1, "t9");
		Thread t10 = new Thread(demo1, "t10");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}
}


