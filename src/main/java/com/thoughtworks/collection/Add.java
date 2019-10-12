package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int start = Math.min(leftBorder,rightBorder);
        int end = Math.max(leftBorder,rightBorder);

        return IntStream.rangeClosed(start, end)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int start = Math.min(leftBorder,rightBorder);
        int end = Math.max(leftBorder,rightBorder);

        return IntStream.rangeClosed(start, end)
                .filter(number -> number % 2 != 0)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(number -> (number * 3)+2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(number ->{
                    if(number%2!=0){
                        return number * 3 + 2;
                    }
                    return number;
             }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number%2!=0)
                .mapToInt(number -> number * 3 +5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream()
                .filter(number -> number%2==0)
                .collect(Collectors.toList());
        if(list.size()%2==0){
            return (list.get((list.size()/2) - 1)
                    + list.get((list.size()/2))) >> 1;
        }
        else{
            return list.get(list.size()/2);
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum() / arrayList.stream()
                .filter(number -> number%2==0)
                .collect(Collectors.toList()).size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(number -> number%2==0)
                .anyMatch(n -> n==specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number%2==0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream()
                .filter(number -> number%2==0)
                .collect(Collectors.toList());

        List<Integer> odd = arrayList.stream()
                .filter(number -> number%2!=0)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> evenThenOdd = new ArrayList<Integer>();
            evenThenOdd.addAll(even);
            evenThenOdd.addAll(odd);
        return evenThenOdd;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> procesedList =  arrayList.stream()
                .map(number -> number*3)
                .collect(Collectors.toList());

        List<Integer> finalList = new ArrayList<>();
        procesedList.stream()
                .reduce((n,v) -> {
                    finalList.add(n + v);
                    return v;
                });

        return finalList;
    }

}
