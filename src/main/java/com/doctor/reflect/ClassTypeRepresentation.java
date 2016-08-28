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

import java.util.Collection;

/**
 * @author sdcuike
 *
 *         Created At 2016年8月28日 下午4:03:21
 */
public class ClassTypeRepresentation {

    public static void main(String[] args) {
        System.out.println(int.class.isPrimitive());// true
        System.out.println(Collection.class.isInterface());// true
        System.out.println(Object[].class.isArray());// true
        System.out.println(int[].class.getComponentType());// int
        System.out.println(DemoInterface.class.isInterface());// true
        System.out.println(DemoInterface.class.isAnnotation());// true
        System.out.println(void.class.isPrimitive());// true

    }

    public static @interface DemoInterface {
        String value() default "";
    }

}
