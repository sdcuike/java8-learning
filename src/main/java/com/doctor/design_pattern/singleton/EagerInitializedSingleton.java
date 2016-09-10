package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月31日 下午11:36:05
 * 
 *         饿汉式 单例 EagerInitialized Singleton
 * 
 *         If your singleton class is not using a lot of resources, this is the
 *         approach to use. But in most of the scenarios, Singleton classes are
 *         created for resources such as File System, Database connections etc
 *         and we should avoid the instantiation until unless client calls the
 *         getInstance method. Also this method doesn’t provide any options for
 *         exception handling.
 * 
 *         饿汉式单例在类加载的时候就初始化资源，只提供一次加载资源/初始化的机会，失败导致资源不能正常初始化
 */
public class EagerInitializedSingleton implements Cloneable {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    /**
     * 反射导致单例失败：How to fix: Throw Runtime Exception if someone tries to make
     * instance in case one instance already exists. This code will go into the
     * private constructor of the Singleton class
     */
    private EagerInitializedSingleton() {
        if (instance != null) {
            throw new RuntimeException("plean use  getInstance() method");
        }
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("test");
    }

    /**
     * 克隆破坏单例：How to fix: Throw CloneNotSupportedException from the clone ()
     * method if someone tries to make other instance of it
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        if (instance != null) {
            throw new CloneNotSupportedException("plean use  getInstance() method");
        }
        return super.clone();
    }

    public static void main(String[] args) throws ReflectiveOperationException, SecurityException, CloneNotSupportedException {
        System.out.println(EagerInitializedSingleton.getInstance());
        System.out.println(EagerInitializedSingleton.getInstance());
        EagerInitializedSingleton.getInstance().doSomething();
        // com.doctor.design_pattern.singleton.EagerInitializedSingleton@2a139a55
        // com.doctor.design_pattern.singleton.EagerInitializedSingleton@2a139a55
        // test

        System.out.println(EagerInitializedSingleton.getInstance() == EagerInitializedSingleton.getInstance());
        // true

        // 反射破坏
        // Constructor<EagerInitializedSingleton> constructor =
        // EagerInitializedSingleton.class.getDeclaredConstructor();
        // constructor.setAccessible(true);
        // EagerInitializedSingleton newInstance = constructor.newInstance();
        // System.out.println(newInstance);

        // 克隆破坏
        System.out.println("克隆破坏:");
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton eagerInitializedSingletonClone = (EagerInitializedSingleton) eagerInitializedSingleton.clone();
        System.out.println(eagerInitializedSingleton + "==" + eagerInitializedSingletonClone + " is " + (eagerInitializedSingleton == eagerInitializedSingletonClone));
    }

}
