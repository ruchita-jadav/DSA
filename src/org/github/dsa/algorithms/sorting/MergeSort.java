package org.github.dsa.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] input = {5, 16, 34, 3, 22, 1};//{51, 12, 83, 34, 95, 26, 47, 78, 69};
        mergeSort(input, 0, input.length - 1);
        Arrays.stream(input).forEach(System.out::println);
    }

    private static void mergeSort(int[] input, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
            merge(input, start, mid + 1, end);
        }
    }

    private static void merge(int[] input, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int c1 = start;
        int c2 = mid;
        for (int k = 0; k < temp.length; k++) {
            if (c1 > mid - 1) {
                temp[k] = input[c2++];
            } else if (c2 > end) {
                temp[k] = input[c1++];
            } else if (input[c1] < input[c2]) {
                temp[k] = input[c1++];
            } else {
                temp[k] = input[c2++];
            }
        }
        c1 = 0;
        while (start <= end) {
            input[start++] = temp[c1++];
        }
    }
}
