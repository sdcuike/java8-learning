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

import java.util.Vector;

/**
 * @author sdcuike
 *
 *         Created At 2016年8月28日 下午2:55:57
 * 
 *         在java中获取Class有两种方式
 */
public class HowGetClass {

    /**
     * 在java中获取Class有两种方式
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 1.
        @SuppressWarnings("rawtypes")
        Class vectorClass = Vector.class;
        System.out.println(vectorClass);// class java.util.Vector
        System.out.println(vectorClass.getName());// java.util.Vector
        System.out.println(vectorClass.getSimpleName());// Vector
        System.out.println(vectorClass.getCanonicalName());// java.util.Vector

        // 2.
        Vector<Object> vector = new Vector<>();
        @SuppressWarnings("rawtypes")
        Class<? extends Vector> vectorClass2 = vector.getClass();
        System.out.println(vectorClass2);// class java.util.Vector
    }

}
