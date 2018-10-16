package com.makesailing.neo.t3;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 23:26
 */
public class MyThread extends Thread {

  private int count = 5;

  public MyThread(String name) {
    super(name);
    this.setName(name);
  }

  @Override
  public void run() {
    super.run();
    while (count > 0) {
      count--;
      System.out.println(" 由 " + currentThread().getName() + "计算 ,count" + count);
    }
  }
}
