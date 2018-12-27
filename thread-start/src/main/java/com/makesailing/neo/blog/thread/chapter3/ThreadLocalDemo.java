package com.makesailing.neo.blog.thread.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * # ThreadLocal 可以为每个线程绑定自己的值
 *
 * @author jamie
 * @date 2018/12/27 16:31
 */
public class ThreadLocalDemo {

	public static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

	public void getThreadLocal() {
		System.out.println(Thread.currentThread().getName());
		threadLocal.get().forEach(name -> System.out.println(name));
	}

	public void setThreadLocal(List<String> values) {
		threadLocal.set(values);
	}

	public static void main(String[] args) {

		final ThreadLocalDemo threadLocal = new ThreadLocalDemo();
		new Thread(() -> {
			List<String> params = new ArrayList<>(3);
			params.add("张三");
			params.add("李四");
			params.add("王五");
			threadLocal.setThreadLocal(params);
			threadLocal.getThreadLocal();
		}).start();

		new Thread(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(10);
				List<String> params = new ArrayList<>(2);
				params.add("Chinese");
				params.add("English");
				threadLocal.setThreadLocal(params);
				threadLocal.getThreadLocal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

	}
}


