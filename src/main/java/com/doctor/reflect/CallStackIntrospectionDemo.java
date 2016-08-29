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

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Call stack introspection
 * 
 * @author sdcuike
 *
 *         Created At 2016年8月29日 下午9:40:35
 */
public class CallStackIntrospectionDemo {
    private static final MyLogger logger = new LoggerImpl();

    public static void main(String[] args) {
        logger.logRecord("hello");

        IllegalArgumentException exception = new IllegalArgumentException("IllegalArgumentException");
        logger.logProblem("throwable", exception);
    }

    public interface MyLogger {
        // Types for log records
        int ERROR   = 0;
        int WARNING = 100;
        int STATUS  = 200;
        int DEBUG   = 300;
        int TRACE   = 400;

        void logRecord(String message);

        void logProblem(String message, Throwable throwable);
    }

    public static class LoggerImpl implements MyLogger {

        @Override
        public void logRecord(String message) {
            Throwable throwable = new Throwable();
            log(message, throwable.getStackTrace()[1]);
        }

        @Override
        public void logProblem(String message, Throwable throwable) {
            StringWriter out = new StringWriter();
            PrintWriter writer = new PrintWriter(out);
            throwable.printStackTrace(writer);
            log(message + out.toString(), throwable.getStackTrace()[0]);
        }

        private void log(String message, StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            int lineNumber = stackTraceElement.getLineNumber();
            System.out.println(String.join("  ", "模拟打印日志:", methodName, className, "" + lineNumber, message));
        }

    }
}
