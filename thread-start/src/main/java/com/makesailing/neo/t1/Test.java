package com.makesailing.neo.t1;

/**
 * # Thread.start() 方法通知 "线程规划器",此线程已经做好准备就绪,等待调用线程的run()方法.这个过程其实就是让系统安排
 *  * 一个时间来调用Thread中的run()方法,也就是使线程得到运行,启动了线程,具有异步的效果.
 *  * 如是调用thread.run就不是异步执行,而是同步,那么此线程对象并不交给 "线程规划器"来执行,而是由mian主主线来调用run()
 *  方法执行.
 *
 * @Author: jamie.li
 * @Date: Created in  2018/10/16 22:59
 */
public class Test {

  public static void main(String[] args) {
    try {
      MyThread thread = new MyThread();
      thread.setName("myThread");
      thread.start();
      for (int i = 0; i < 10; i++) {
        int time = (int) (Math.random() * 1000);
        Thread.sleep(time);
        System.out.println("main=" + Thread.currentThread().getName());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
