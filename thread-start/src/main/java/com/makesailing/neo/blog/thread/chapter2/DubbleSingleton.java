package com.makesailing.neo.blog.thread.chapter2;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * # 单例模式-双重校验锁
 *
 * @author jamie
 * @date 2018/12/27 16:20
 */
public class DubbleSingleton {

	// 加 volatile 防止指令的重排
	private static volatile DubbleSingleton instance = null;

	private DubbleSingleton() {
	}

	public static DubbleSingleton getInstance() {

		// 判断实例是否被其他线程创建,如是没有则创建
		if (Objects.isNull(instance)) {
			try {
				// 模拟初始化对象的时间
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 类上加锁时,表示当前对象不可以在其他线程的时候创建
			synchronized (DubbleSingleton.class) {
				//  如果不加这一层判断的话,这样的话每一个都有得到一个实例,而不是所有的线程得到的是一个实例
				if (Objects.isNull(instance)) { // 从第一次判断是否为Null到加锁之间的时间内判断实例是否已经被创建
					instance = new DubbleSingleton();
					return instance;
				}
			}

		}
		return instance;
	}
}


