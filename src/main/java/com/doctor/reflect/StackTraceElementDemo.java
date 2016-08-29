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

/**
 * StackTraceElement[] java.lang.Throwable.getStackTrace() 获取方法调用栈信息
 * 
 * @author sdcuike
 *
 *         Created At 2016年8月30日 上午12:07:50
 */
public class StackTraceElementDemo {

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        demo2();
    }

    public static void demo2() {
        demo3();
    }

    public static void demo3() {
        Throwable t = new Throwable();
        StackTraceElement[] stackTrace = t.getStackTrace();
        for (StackTraceElement e : stackTrace) {
            System.out.println(String.join("-", e.getClassName(), "" + e.getLineNumber(), e.getMethodName()));
        }
    }

}
