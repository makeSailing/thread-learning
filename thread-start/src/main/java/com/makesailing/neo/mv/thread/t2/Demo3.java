package com.makesailing.neo.mv.thread.t2;

/**
 * # 匿名创建线程
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/23 22:25
 */
public class Demo3 {

    public static void main(String[] args) {
        // 匿名内部类实现,只适合创建一次线程
//        new Thread(){
//            @Override
//            public void run() {
//                System.out.println("thread start ...");
//            }
//        }.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread start ...");
//            }
//        }).start();


        //如果同时匿名 实现Ruunable与继承Thread类,则只有继承Thread中会生效
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("sub");
            }
        }.start();
    }
}
