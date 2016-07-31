package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月31日 下午11:36:05
 * 
 *         饿汉式 单例
 *         EagerInitialized Singleton
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
