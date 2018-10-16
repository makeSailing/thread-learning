package com.makesailing.neo.t2;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 23:23
 */
public class Run {

  public static void main(String[] args) {
    MyRunnable runnable = new MyRunnable();
    Thread thread = new Thread(runnable);
    thread.start();
    System.out.println(" 运行线束~ ");
  }
}
