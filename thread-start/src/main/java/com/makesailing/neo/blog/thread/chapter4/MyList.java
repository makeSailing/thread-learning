package com.makesailing.neo.blog.thread.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * #
 *
 * @author jamie
 * @date 2018/12/27 17:20
 */
public class MyList {

	private static List<Object> list = new ArrayList<>();

	public static void add() {
		list.add("我是元素");
	}

	public static int size() {
		return list.size();
	}
}


