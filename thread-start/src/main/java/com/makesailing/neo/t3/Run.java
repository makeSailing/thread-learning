package com.makesailing.neo.t3;

/**
 * # 一个创建了3个线程,每个线程都有各自的count变量,自己减少自己的count变量的值 .
 * 这样的情况就是变量不共享
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 23:31
 */
public class Run {

  public static void main(String[] args) {
    MyThread a = new MyThread("A");
    MyThread b = new MyThread("B");
    MyThread c = new MyThread("C");
    a.start();
    b.start();
    c.start();
  }
}
