package org.github.dsa.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1, 4, 6,3, 8, 5, 2, 9};
        selectionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
