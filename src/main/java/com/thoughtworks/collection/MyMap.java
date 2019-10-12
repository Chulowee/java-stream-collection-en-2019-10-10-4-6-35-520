package com.thoughtworks.collection;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    private static final int ALPHABET_COUNT = 26;
    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return  array.stream()
                .map(number -> number * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream()
                .map(n -> letterList.get(n - 1))
                .collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream()
                .map(this::getMappedLetter)
                .collect(Collectors.toList());
    }
    private String getMappedLetter(int index) {
        int trueIndex = --index;
        if (++index > ALPHABET_COUNT) {
            return letterList.get((trueIndex / ALPHABET_COUNT) - 1) +
                    letterList.get(trueIndex % ALPHABET_COUNT);
        }
        return letterList.get(trueIndex);
    }

    public List<Integer> sortFromBig() {
        return array.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
