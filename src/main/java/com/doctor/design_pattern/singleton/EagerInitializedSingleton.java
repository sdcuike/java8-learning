package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月31日 下午11:36:05
 * 
 *         饿汉式 单例
 *         EagerInitialized Singleton
 * 
 *         If your singleton class is not using a lot of resources, this is the approach to use.
 *         But in most of the scenarios, Singleton classes are created for resources
 *         such as File System, Database connections etc and we should avoid
 *         the instantiation until unless client calls the getInstance
 *         method. Also this method doesn’t provide any options for exception handling.
 */
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        System.out.println(EagerInitializedSingleton.getInstance());
        System.out.println(EagerInitializedSingleton.getInstance());
        EagerInitializedSingleton.getInstance().doSomething();
        // com.doctor.design_pattern.singleton.EagerInitializedSingleton@2a139a55
        // com.doctor.design_pattern.singleton.EagerInitializedSingleton@2a139a55
        // test

        System.out.println(EagerInitializedSingleton.getInstance() == EagerInitializedSingleton.getInstance());
        // true
    }

}
