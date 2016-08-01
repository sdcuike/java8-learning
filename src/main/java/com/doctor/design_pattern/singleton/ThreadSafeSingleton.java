package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Created on 2016年8月1日 上午11:19:36
 * 
 *         Thread Safe Singleton
 * 
 *         The easier way to create a thread-safe singleton class is to make the global access
 *         method synchronized,
 *         so that only one thread can execute this method at a time.
 *         General implementation of this approach is like the below class.
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    private ThreadSafeSingleton() {

    }

    public static void main(String[] args) {
        System.out.println(ThreadSafeSingleton.getInstance() == ThreadSafeSingleton.getInstance());
        // true
    }

}
