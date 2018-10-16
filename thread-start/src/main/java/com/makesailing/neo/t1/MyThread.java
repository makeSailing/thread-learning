package com.makesailing.neo.t1;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 22:50
 */
public class MyThread extends Thread {

  @Override
  public void run() {
    super.run();

    try {
      for (int i = 0; i < 10; i++) {
        int time = (int) (Math.random() * 1000);
        Thread.sleep(time);
        System.out.println("run=" + Thread.currentThread().getName());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    myThread.start();
    System.out.println(" 运行结束 ");
  }


}
