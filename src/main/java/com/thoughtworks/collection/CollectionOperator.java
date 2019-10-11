package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        throw new NotImplementedException();
    }
    public List<Integer> getEvenListByIntervals(int left, int right) {
        throw new NotImplementedException();
    }
    public List<Integer> popEvenElments(int[] array) {
        throw new NotImplementedException();
    }
    public int popLastElment(int[] array) {
        return Arrays.stream(array).reduce((a, b) -> b).getAsInt();
    }
    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .boxed()
                .filter(number -> Arrays.stream(secondArray)
                        .anyMatch(numberB -> number == numberB))
                .collect(Collectors.toList());
    }
    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        return Stream.concat(Arrays.stream(firstArray),
                Arrays.stream(secondArray))
                .distinct()
                .collect(Collectors.toList());
    }
}
