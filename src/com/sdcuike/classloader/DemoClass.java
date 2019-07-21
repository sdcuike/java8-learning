package com.sdcuike.classloader;

/**
 * @author sdcuike
 * @date 2019-06-17
 */
public class DemoClass {
    private String name = "doctor who";

    @Override
    public String toString() {
        return "DemoClass{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new DemoClass());
    }
}
