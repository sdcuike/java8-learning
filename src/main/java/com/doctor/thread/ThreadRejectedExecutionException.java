package com.doctor.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description
 *
 * @author sdcuike
 *
 * @date 2016年7月15日 下午6:58:09
 */
public class ThreadRejectedExecutionException {

    public static void main(String[] args) throws InterruptedException {

        int maximumPoolSize = 2;
        int corePoolSize = 2;
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0, TimeUnit.MICROSECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
        threadPool.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("beginning 1");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("end 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        System.out.println(ThreadPoolExecutorUtil.getInfo(threadPool));
        threadPool.submit(new Runnable() {
            public void run() {
                try {
                    System.out.println("beginning 2");
                    TimeUnit.MINUTES.sleep(10);
                    System.out.println("end 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(ThreadPoolExecutorUtil.getInfo(threadPool));
        threadPool.submit(new Runnable() {
            public void run() {
                try {
                    System.out.println("beginning 3");
                    TimeUnit.MINUTES.sleep(10);
                    System.out.println("end 3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(ThreadPoolExecutorUtil.getInfo(threadPool));
        TimeUnit.MINUTES.sleep(50);

        threadPool.shutdown();
    }

}
