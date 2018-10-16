package com.makesailing.neo.z;

/**
 * # 执行start()方法的顺序不代表线程启动的顺序
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 23:06
 */
public class MyThread extends Thread {

  private int i;

  public MyThread(int i) {
    super();
    this.i = i;
  }

  @Override
  public void run() {
    super.run();
    System.out.println(i);
  }
}
