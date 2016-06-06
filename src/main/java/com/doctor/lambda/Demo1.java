package com.doctor.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @author sdcuike
 *
 *         Created on 2016年6月7日 上午12:03:18
 */
public class Demo1 {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("test lambda");
        new Thread(runnable).start();

        String msg = "hello ";
        runnable = () -> {
            System.out.println(msg);
            System.out.println("run 1");
            System.out.println("run 2");
        };

        new Thread(runnable).start();
        Consumer<String> consumer = message -> System.out.println(message);
        consumer.accept("hello java lambda ");

        BinaryOperator<Long> add = (a, b) -> a + b;
        System.out.println(add.apply(66L, 22L));
        add = (Long a, Long b) -> a + b;
        System.out.println(add.apply(66L, 33L));
    }

}
