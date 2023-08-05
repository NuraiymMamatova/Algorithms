package com.example.algorithms;

import java.util.Arrays;

public class MyCompare {
    private static final char[] CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main() {
        String[] array = {"dog", "TIGR", "Cat", "Rabbit", "Child"};
        System.out.println("Дан массив: " + Arrays.toString(array) + ";");

        array = bubbleSort(array);
        System.out.println("После сортировки: " + Arrays.toString(array));
    }

    public static String[] bubbleSort(String[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (compare(array[j], array[j + 1]) > 0) {
                        array = swap(array, j, j + 1);
                    }
                }
            }
        }
        return array;
    }

    private static String[] swap(String[] array, int i, int j) {
        if (array != null && i >= 0 && i < array.length && j >= 0 && j < array.length) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    private static int compare(String first, String second) {
        int result = 0;
        if (first != null && second != null) {
            char[] firstChars = first.trim().toCharArray();
            char[] secondChars = second.trim().toCharArray();
            int min = Math.min(firstChars.length, secondChars.length);
            int firstCode;
            int secondCode;
            for (int index = 0; index < min; index++) {
                firstCode = getCode(firstChars[index]);
                secondCode = getCode(secondChars[index]);
                if (firstCode == 0 || secondCode == 0) {
                    throw new IllegalArgumentException();
                } else {
                    if (firstCode != secondCode) {
                        result = firstCode - secondCode;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static int getCode(char symbol) {
        int result = 0;
        for (int index = 0; index < CHARS.length; index++) {
            if (CHARS[index] == Character.toUpperCase(symbol)) {
                result = ++index;
                break;
            }
        }
        return result;
    }
}