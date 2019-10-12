package com.thoughtworks.collection;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.IntStream.rangeClosed;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int minLimit = Math.min(left, right);
        int maxLimit = Math.max(left, right);
        List<Integer> intervalList = rangeClosed(minLimit, maxLimit)
                .boxed()
                .collect(Collectors.toList());
        if (left > right) {
            Collections.reverse(intervalList);
        }
        return intervalList;
    }
    public List<Integer> getEvenListByIntervals(int left, int right) {
        int minLimit = Math.min(left, right);
        int maxLimit = Math.max(left, right);
        List<Integer> intervalList = rangeClosed(minLimit, maxLimit)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        if (left > right) {
            Collections.reverse(intervalList);
        }
        return intervalList;
    }
    public List<Integer> popEvenElements(int[] array) {
        return Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
    public int popLastElement(int[] array) {
        return Arrays.stream(array)
                .reduce((a, b) -> b)
                .orElse(0);
    }
    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .filter(n -> Arrays.stream(secondArray)
                        .anyMatch(m -> m == n))
                .boxed()
                .collect(Collectors.toList());
    }
    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        return Stream.concat(Arrays.stream(firstArray),
                Arrays.stream(secondArray))
                .distinct()
                .collect(Collectors.toList());
    }
}
