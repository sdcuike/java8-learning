package com.doctor.thread;

/**
 * @author sdcuike
 * @date 2019-07-21
 */
public final class SynchronizedKeyWord {
    public static void main(String[] args) {
        SynchronizedKeyWord synchronizedKeyWord = new SynchronizedKeyWord();
        synchronizedKeyWord.method();
        synchronizedKeyWord.method2();

        SynchronizedKeyWord.method3();
        SynchronizedKeyWord.method5();
    }

    public synchronized void method() {
        System.out.println("method:" + Thread.holdsLock(this));
    }

    public void method2() {
        synchronized (this) {
            System.out.println("method2:" + Thread.holdsLock(this));
        }
    }


    public static synchronized void method3() {
        System.out.println("method3:" + Thread.holdsLock(SynchronizedKeyWord.class));
    }

    public static void method5() {
        synchronized (SynchronizedKeyWord.class) {
            System.out.println("method5:" + Thread.holdsLock(SynchronizedKeyWord.class));
        }
    }

}
