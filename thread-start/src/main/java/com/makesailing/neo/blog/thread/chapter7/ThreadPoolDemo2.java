package com.makesailing.neo.blog.thread.chapter7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * # ExcutorService.submit() 遇到异常不会抛出,会被内部进行捕获,不容易定位问题
 * # ExcutorService.execute() 遇到异常会抛出
 *
 *   总结 :
 *   (1): execute(): 方法用于提交不需要返回值的任务,所以无法判断任务是否被线程执行成功.
 *                  通过源码分析可知 execute()方法的入参是Runnable的实类
 *   (2): submit(): 方法用于提交需要返回值的任务. 线程池会返回一个future类的对象,通过这个future对象
 *                  可以判断任务是否执行成功,并且可以通过future的get方法来获取返回值,get()方法会阻塞当前的
 *                  线程直到任务结束.
 *
 * @Author: jamie.li
 * @Date: Created in  2018/12/30 15:38
 */
public class ThreadPoolDemo2 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        /**
         *  executorService.submit() 运行结果 :
         * 100.0
         * 25.0
         * 50.0
         * 33.0
         *  100/0 的异常没有抛出
         */
//        for (int i = 0; i < 5; i++) {
//            int index = i;
//            executorService.submit(() -> divTask(100, index));
//        }

        /**
         * executorService.execute() 运行结果
         * 异常会进行抛出 : java.lang.ArithmeticException: / by zero
         */
//        for (int i = 0; i < 5; i++) {
//            int index = i;
//            executorService.execute(() -> divTask(100, index));
//        }


        for (int i = 0; i < 5; i++) {
            int index = i;
            Future<?> future = executorService.submit(() -> divTask(100, index));
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    private static void divTask(int num, int index) {
        double result = num / index;
        System.out.println(result);
    }
}
