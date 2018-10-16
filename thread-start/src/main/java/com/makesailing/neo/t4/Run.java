package com.makesailing.neo.t4;

/**
 * #
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 23:36
 */
public class Run {

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    Thread a = new Thread(myThread, "A");
    Thread b = new Thread(myThread, "B");
    Thread c = new Thread(myThread, "C");
    Thread d = new Thread(myThread, "D");
    Thread e = new Thread(myThread, "E");
    Thread f = new Thread(myThread, "F");
    a.start();
    b.start();
    c.start();
    d.start();
    e.start();
    f.start();
  }
}
