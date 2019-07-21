package com.doctor.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 * @date 2019-02-28
 */
public class DeadLock2 {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + " owns lockA");
//                    try {
//                        TimeUnit.SECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    synchronized (lockB) {
                        System.out.println(Thread.currentThread().getName() + " owns lockB");
//                        try {
//                            TimeUnit.SECONDS.sleep(10);
//
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            }
        }, "threadA");

//        threadA.start();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {

                    System.out.println(Thread.currentThread().getName() + " owns lockB");
//                    try {
//                        TimeUnit.SECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    synchronized (lockA) {
                        System.out.println(Thread.currentThread().getName() + " owns lockA");
//                        try {
//                            TimeUnit.SECONDS.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            }
        }, "threadB");
        threadA.start();
        threadB.start();





    }
}
