package com.doctor.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;

/**
 * @author sdcuike
 *
 *         Created on 2016年6月10日 下午6:20:44
 */
public class CommonStreamOperationsDemo {

    public static void main(String[] args) {
        // 1.collect(toList())
        // collect(toList()) is an eager operation that generates a list from the values in a Stream
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        boolean equals = Arrays.asList("a", "b", "c").equals(list);
        Preconditions.checkState(equals); // true

        // 2.map
        // If you’ve got a function that converts a value of one type into another,
        // map lets you apply this function to a stream of values, producing
        // another stream of the new values.
        List<String> mapOperation = Stream.of("a", "b", "doctor who").map(String::toUpperCase).collect(Collectors.toList());
        Preconditions.checkState(Arrays.asList("A", "B", "DOCTOR WHO").equals(mapOperation));

        // 3.filter
        // Any time you’re looping over some data and checking each element,
        // you might want to think about using the new filter method on Stream.

        // 4.flatMap
        // flatMap lets you replace a value with a Stream and concatenates all the streams together.
        List<Integer> flatMapOperation = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(e -> e.stream()).collect(Collectors.toList());
        Preconditions.checkState(Arrays.asList(1, 2, 3, 4).equals(flatMapOperation));

        // 5.max and min
        Integer max = Stream.of(1, 2, 66).max(Integer::compareTo).get();
        Preconditions.checkState(max.equals(66));

        // 6.reduce
        // Use the reduce operation when you’ve got a collection of values and you want to generate
        // a single result. In earlier examples, we used the count, min, and max methods, which are
        // all in the standard library because they are common use cases. All of these are forms of reduction.
        int intValue = Stream.of(1, 2, 3).reduce(0, (acc, e) -> acc + e).intValue();
        Preconditions.checkState(intValue == 6);
    }

}
