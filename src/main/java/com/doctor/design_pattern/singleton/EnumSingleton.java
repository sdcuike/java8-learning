package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Enum Singleton
 *         枚举实现单例不能延迟加载资源，但保证了enum值只实例化一次。而且克服了反射带来的问题
 * 
 *         Created on 2016年8月1日 下午12:24:06
 */
public enum EnumSingleton {
    instance;
    private EnumSingleton() {

    }

    public void doSomething() {
        System.out.println("test do ");
    }

    public static void main(String[] args) {
        EnumSingleton.instance.doSomething();
    }

}
