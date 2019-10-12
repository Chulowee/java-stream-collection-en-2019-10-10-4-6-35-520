package com.thoughtworks.collection;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                .reduce((n,v)->n>v ? n:v)
                .get();
    }

    public double getMinimum() {
        return arrayList.stream()
                .reduce((n,v)->n<v ? n:v)
                .get();
    }

    public double getAverage() {
       return arrayList.stream()
               .reduce(Integer::sum)
               .map(Integer::doubleValue)
               .map(number -> number/arrayList.size())
               .get();
    }

    public double getOrderedMedian() {
        return arrayList.stream()
                .sorted()
                .map(number -> {
                    if (arrayList.size()%2==0){
                        return arrayList.get((arrayList.size()+1)/2) +
                                arrayList.get((arrayList.size()-1)/2) ;
                    }else {
                        return arrayList.get((arrayList.size()+1)/2);
                    }
                })
                .mapToDouble(Integer::doubleValue)
                .reduce((a,b) -> b/2)
                .getAsDouble();
    }

    public int getFirstEven() {
        return arrayList.stream()
                .filter(number -> number%2==0)
                .findFirst()
                .get();
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(
                arrayList.stream()
                        .filter(number -> number%2==0)
                        .reduce((a,b) -> a)
                        .get());
    }

    public boolean isEqual(List<Integer> arrList) {
        int sumOfIntList = arrList.stream()
                .reduce(Integer::sum)
                .orElse(0);
        int sumOfArrayList = arrayList.stream()
                .reduce(Integer::sum)
                .orElse(0);
        return sumOfArrayList == sumOfIntList;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        return arrayList.stream()
                .mapToDouble(Integer::doubleValue)
                .map(number -> {
                    if (arrayList.size()%2==0){
                        return (Double.valueOf(arrayList.get((arrayList.size()+1)/2) +
                                arrayList.get((arrayList.size()-1)/2))/2);
                    }else {
                        return Double.valueOf(arrayList.get(arrayList.size()/2));
                    }
                })
                .reduce((a,b) -> b)
                .getAsDouble();
    }

    public int getLastOdd() {
        return arrayList.stream()
                .filter(number -> number%2!=0)
                .reduce((n,v) -> v)
                .get();
    }

    public int getIndexOfLastOdd() {
        return arrayList.indexOf(
                arrayList.stream()
                .filter(number -> number%2!=0)
                .reduce((n,v) -> v)
                .get());
    }
}
