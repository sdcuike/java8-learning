package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Lazy initialization method to implement Singleton pattern creates the instance in the global access method. Here is the sample code for creating Singleton class with this approach.
 *         Created on 2016年8月1日 上午12:39:40
 * 
 * @see http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }

        return instance;
    }

    private LazyInitializedSingleton() {
    }

    public static void main(String[] args) {
        System.out.println(LazyInitializedSingleton.getInstance() == LazyInitializedSingleton.getInstance());// true
    }

}
