package com.doctor.stream;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * @author sdcuike
 *
 *         Created on 2016年6月10日 下午4:29:32
 * 
 *         It’s very easy to figure out whether an operation is eager or lazy: look at what it returns.
 *         If it gives you back a Stream, it’s lazy; if it gives you back another value or void, then it’s
 *         eager. This makes sense because the preferred way of using these methods is to form a
 *         sequence of lazy operations chained together and then to have a single eager operation
 *         at the end that generates your result.
 * 
 *         This whole approach is somewhat similar to the familiar builder pattern. In the builder
 *         pattern, there are a sequence of calls that set up properties or configuration, followed
 *         by a single call to a build method. The object being created isn’t created until the call
 *         to build occurs
 * 
 *         I’m sure you’re asking, “Why would we want to have the differentiator between lazy and
 *         eager options?” By waiting until we know more about what result and operations are
 *         needed, we can perform the computations more efficiently.
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("doctor", "lily", "who", "doctor who");
        List<String> result = names.stream().filter(e -> {
            System.out.println("filter 1 :" + e);
            return e.startsWith("do");
        }).filter(e -> {
            System.out.println("filter 2 :" + e);
            return e.startsWith("doctor");
        }).collect(Collectors.toList());

        System.out.println("result:" + result);
    }

}
