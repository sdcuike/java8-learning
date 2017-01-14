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
package com.doctor.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author sdcuike
 *
 *         Created At 2017年1月14日 下午5:05:44
 */
public class JdkBase64 {

    public static void main(String[] args) {
        String plainText = "Base64算法最早主要是解决电子邮件的传输问题，"
                + "由于当时的网关有个问题就是可能会度非ASCII码字符的二进制位做调整，"
                + "导致用户收取的邮件变成乱码，所以就出现了Base64算法";

        // 无回车换行符号
        String base64String = Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
        System.out.println(base64String);

        System.out.println(new String(Base64.getDecoder().decode(base64String), StandardCharsets.UTF_8));
        // 出现回车换行符号
        System.out.println("===============");
        base64String = Base64.getMimeEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
        System.out.println(base64String);
        System.out.println(new String(Base64.getMimeDecoder().decode(base64String), StandardCharsets.UTF_8));

    }
}
