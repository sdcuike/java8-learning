package com.sdcuike.classloader;

import java.security.SecureClassLoader;

/**
 * @author sdcuike
 * @date 2019-06-17
 */
public class DemoClassLoader extends SecureClassLoader {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String root = DemoClassLoader.getSystemResource("").toString();
        root = root.substring(0, root.indexOf("target"));

        System.out.println(root );
        Class<?> loadClass = DemoClassLoader.getSystemClassLoader().loadClass("com.sdcuike.classloader.DemoClass");

        System.out.println(loadClass.newInstance());
    }
}
