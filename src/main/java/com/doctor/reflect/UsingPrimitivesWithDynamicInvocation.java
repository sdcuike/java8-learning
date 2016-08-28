/*
 * Copyright 2016    https://github.com/sdcuike Inc. 
 * All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.doctor.reflect;

import java.lang.reflect.Method;

/**
 * Using primitives with dynamic invocation
 * 
 * @author sdcuike
 * 
 *         Created At 2016年8月28日 下午5:44:55
 */
public class UsingPrimitivesWithDynamicInvocation {

    public static void main(String[] args) throws ReflectiveOperationException, SecurityException {
        // 自动拆箱操作参数，返回值自动装箱操作
        DemoClass demoClass = new DemoClass();
        Method method = demoClass.getClass().getMethod("getAge", new Class[] { int.class });
        Object invoke = method.invoke(demoClass, Integer.valueOf(11));
        System.out.println(invoke.getClass());// class java.lang.Integer
        int age = ((Integer) invoke).intValue();// 需要手动拆箱操作
        System.out.println(age);

        // 无返回值情况
        Method method2 = demoClass.getClass().getMethod("print", new Class[] {});
        Object invoke2 = method2.invoke(demoClass);
        System.out.println(invoke2);// null

        // 当方法返回原生类型数组的时候，不进行装箱操作
        Method getArray = demoClass.getClass().getMethod("getArray", new Class[] {});
        Object invoke3 = getArray.invoke(demoClass);
        System.out.println(invoke3.getClass());// class [I
        int[] array = (int[]) invoke3;
        for (int i : array) {
            System.out.println(i);
        }

    }

    public static class DemoClass {
        public int getAge(int age) {
            return age;
        }

        public int[] getArray() {
            return new int[] { 11, 66, 88 };
        }

        public void print() {
            System.out.println("==");
        }
    }

}
