package org.github.dsa.algorithms.sorting;

import java.util.Arrays;

// Time complexity : O(nlog(n)) || Space complexity :  O(n)
public class MergeSortEfficient {

    public static void main(String[] args) {
        int[] input = {5, 36, 4, 3, 22, 1, 51,12, 83, 34, 95, 26, 47, 78, 69};
        mergeSort(input, Arrays.copyOf(input, input.length), 0, input.length - 1);
        Arrays.stream(input).forEach(System.out::println);
    }

    private static void mergeSort(int[] input, int[] aux, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(aux, input, start, mid);
            mergeSort(aux, input, mid + 1, end);
            merge(input, aux, start, mid + 1, end);
        }
    }

    private static void merge(int[] input, int[] aux, int start, int mid, int end) {
        int midp = mid;
        for (int k = start; k < end + 1; k++) {
            if ( start >= mid) {
                input[k] = aux[midp++];
            } else if (midp > end) {
                input[k] = aux[start++];
            } else if (aux[start] < aux[midp]) {
                input[k] = aux[start++];
            } else {
                input[k] = aux[midp++];
            }
        }
    }
}
