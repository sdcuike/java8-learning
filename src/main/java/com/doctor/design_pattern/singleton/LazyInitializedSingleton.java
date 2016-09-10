package com.doctor.design_pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sdcuike
 *
 *         Lazy initialization method to implement Singleton pattern creates the
 *         instance in the global access method. Here is the sample code for
 *         creating Singleton class with this approach. Created on 2016年8月1日
 *         上午12:39:40
 * 
 * @see http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 *      懒初始化，多线程会导致破坏单例原则
 */
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    /**
     * 为了模拟多线程情况下的问题，加入了休眠时间
     * 
     * @return
     */
    public static LazyInitializedSingleton getInstance() {
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
            instance = new LazyInitializedSingleton();
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    private LazyInitializedSingleton() {
    }

    public static void main(String[] args) {
        // System.out.println(LazyInitializedSingleton.getInstance() ==
        // LazyInitializedSingleton.getInstance());// true
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(LazyInitializedSingleton.getInstance());
            });
        }

        executorService.shutdown();
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@6a1bb74
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@6a1bb74
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@6a1bb74
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@2be16806
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@2be16806
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@5f93f536
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@5f93f536
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@5f93f536
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@5f93f536
        // com.doctor.design_pattern.singleton.LazyInitializedSingleton@46d3a9
        // 得到的实例并不是同一个。
    }

}
