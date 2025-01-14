package com.thoughtworks.collection;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> list = new ArrayList<>();
        do {
            number -= 2;
            list.add(number);
        }while (number > 1);
        return list;
    }
}
