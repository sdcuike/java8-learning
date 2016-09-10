package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Created on 2016年8月1日 上午11:37:25
 * 
 *         double checked locking principle and volatile variable
 */
public class DoubleCheckedLockingThreadSafeSingleton {

    private static volatile DoubleCheckedLockingThreadSafeSingleton instance;

    /**
     * double check的目的是为了进步一获得线程安全，第一步check为null的时候可能先后进来两个线程访问，此时单例还没初始化，
     * 这个时候开始上锁，如果前一个线程上锁后初始化了这个单例而释放锁，那后边的线程也可以锁定对象，然后初始化，
     * 这样就违背了单例原则，所以我们在锁住对象后又进一步check对象是否初始化了。
     * 不过，由于java内存的可见性问题（java内存模型），一个线程初始化了对象，double
     * check的时候，并不一定能时时判断实例是否被另一个线程初始化了，所以上面的代码还是有线程安全问题的，
     * 所以我们必须在实例变量声明的时候加上关键字volatile，使得多线程对变量的修改能时时的让其他线程看到这个结果。
     * 
     * @return
     */
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
