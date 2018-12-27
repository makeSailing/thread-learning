package com.makesailing.neo.blog.thread.chapter2;

import java.util.Objects;

/**
 * # 普通加锁的单例模式
 *
 * @author jamie
 * @date 2018/12/27 16:16
 */
public class Singleton {

	// 懒汉式
	private static Singleton instance = null;
	// 饿汉式
	//private static Singleton instance = new Singleton();

	// 防止其他类创建,这里私有化空参构造
	private Singleton() {
	}

	public static synchronized Singleton createSingleton() {
		if (Objects.isNull(instance)) {
			instance = new Singleton();
		}
		return instance;
	}
}



