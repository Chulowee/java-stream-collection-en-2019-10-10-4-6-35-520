package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
               .reduce((n,v)->n+v)
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

//    public int getIndexOfFirstEven() {
//        return arrayList.stream()
//                .filter(number -> number%2==0)
//                .findFirst()
//                .map()
//                .get().;
//    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

//    public Double getMedianInLinkList(SingleLink singleLink) {
//        return arrayList.stream()
//                .map(number -> {
//                    if (arrayList.size()%2==0){
//                        return arrayList.get((arrayList.size()+1)/2) +
//                                arrayList.get((arrayList.size()+2)/2);
//                    }
////                    return number;
//                })
//                .reduce((n,b)-> n/2)
//                .get()
//                .doubleValue();
//    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
