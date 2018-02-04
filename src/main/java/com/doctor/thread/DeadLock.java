package com.doctor.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sdcuike
 * @date 2018/2/4
 * @since 2018/2/4
 */
public class DeadLock {
    private Lock lockA = new ReentrantLock();
    private Lock lockB = new ReentrantLock();
    
    public void operation1() {
        lockA.lock();
        lockB.lock();
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockB.unlock();
            lockA.unlock();
        }
    }
    
    public void operation2() {
        lockB.lock();
        lockA.lock();
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockA.unlock();
            lockB.unlock();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();
        
        new Thread(()->{
            deadLock.operation1();
        }).start();
        
        new Thread(()->{
            deadLock.operation2();
        }).start();
        
        TimeUnit.SECONDS.sleep(5);
    
    }
}
