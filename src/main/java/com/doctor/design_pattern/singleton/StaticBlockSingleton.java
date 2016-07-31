package com.doctor.design_pattern.singleton;

/**
 * @author sdcuike
 *
 *         Created on 2016年8月1日 上午12:30:08
 * 
 *         <h1>Static block initialization Singleton</h1>
 * 
 *         Static block initialization implementation is similar to eager initialization,
 *         except that instance of class is created in the static block
 *         that provides option for exception handling.
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static void main(String[] args) {
        System.out.println(StaticBlockSingleton.getInstance());
        System.out.println(StaticBlockSingleton.getInstance());

        System.out.println(StaticBlockSingleton.getInstance() == StaticBlockSingleton.getInstance());

        // com.doctor.design_pattern.singleton.StaticBlockSingleton@2a139a55
        // com.doctor.design_pattern.singleton.StaticBlockSingleton@2a139a55
        // true

    }

}
