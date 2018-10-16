package com.makesailing.neo.t4;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 23:35
 */
public class MyThread extends Thread {

  private int count = 5;

  @Override
  public synchronized void  run() {
    super.run();
    while (count > 0) {
      count--;
      System.out.println(" 由 " + currentThread().getName() + "计算 ,count" + count);
    }
  }
}
