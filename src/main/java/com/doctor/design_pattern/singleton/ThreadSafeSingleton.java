package com.doctor.design_pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sdcuike
 *
 *         Created on 2016年8月1日 上午11:19:36
 * 
 *         粗粒度锁带来的单例线程安全
 * 
 *         Thread Safe Singleton
 * 
 *         The easier way to create a thread-safe singleton class is to make the
 *         global access method synchronized, so that only one thread can
 *         execute this method at a time. General implementation of this
 *         approach is like the below class.
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    public static synchronized ThreadSafeSingleton getInstance() {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (instance == null) {
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new ThreadSafeSingleton();
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private ThreadSafeSingleton() {

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(ThreadSafeSingleton.getInstance());
            });
        }

        executorService.shutdown();
    }

}
