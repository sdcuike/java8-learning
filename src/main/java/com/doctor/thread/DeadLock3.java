package com.doctor.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 * @date 2019-02-28
 */
public class DeadLock3 {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    private static CountDownLatch countDownLatchA = new CountDownLatch(2);
    private static CountDownLatch countDownLatchB = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    countDownLatchB.await();

                    countDownLatchA.await();
                    countDownLatchA.countDown();
                    countDownLatchB.countDown();




                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadA");
        threadA.start();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    countDownLatchA.await();


                    countDownLatchB.await();
                    countDownLatchB.countDown();
                    countDownLatchA.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadB");


        threadB.start();


    }
}
