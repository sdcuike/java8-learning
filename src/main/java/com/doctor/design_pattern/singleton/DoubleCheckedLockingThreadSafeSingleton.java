package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Created on 2016年8月1日 上午11:37:25
 * 
 *         double checked locking principle
 */
public class DoubleCheckedLockingThreadSafeSingleton {

    private static DoubleCheckedLockingThreadSafeSingleton instance;

    public static DoubleCheckedLockingThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingThreadSafeSingleton();
                }
            }
        }

        return instance;
    }

    private DoubleCheckedLockingThreadSafeSingleton() {

    }

    public static void main(String[] args) {

    }

}
