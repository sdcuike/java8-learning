package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Inner static helper class Singleton
 * 
 *         Notice the private inner static class that contains the instance of the singleton class. When the singleton class is loaded, SingletonHelper class is not loaded into memory and only when someone calls the getInstance method, this class gets loaded and creates the Singleton class instance.
 * 
 *         This is the most widely used approach for Singleton class as it doesn’t require synchronization. I am using this approach in many of my projects and it’s easy to understand and implement also.
 *         Created on 2016年8月1日 上午11:54:05
 */
public class InnerStaticHelperClassSingleton {
    private InnerStaticHelperClassSingleton() {

    }

    public static InnerStaticHelperClassSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        static {
            System.out.println("SingletonHelper class load");
        }

        private static final InnerStaticHelperClassSingleton instance = new InnerStaticHelperClassSingleton();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(InnerStaticHelperClassSingleton.class);
        Class.forName("com.doctor.design_pattern.singleton.InnerStaticHelperClassSingleton");
        System.out.println("get Singleton instance");
        System.out.println(InnerStaticHelperClassSingleton.getInstance() == InnerStaticHelperClassSingleton.getInstance());
    }

}
