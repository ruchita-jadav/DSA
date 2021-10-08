package org.github.dsa.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,8,4,5,12,11,13};//{9, 7, 1, 4, 2, 3};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end <= start)
            return;
        int pivot = sort(arr, start, end);
        // Logic is to first sort the small array part among left and right
        if ((pivot - 1 - start) < (end - pivot + 1)) {
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        } else {
            quickSort(arr, pivot + 1, end);
            quickSort(arr, start, pivot - 1);
        }
    }

    private static int sort(int[] arr, int start, int end) {
        int pivot = start++;
        while (end >= start) {
            if (arr[start] > arr[pivot] && arr[end] < arr[pivot]) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            if (arr[start] <= arr[pivot]) {
                start++;
            }
            if (arr[end] >= arr[pivot]) {
                end--;
            }
        }
        int temp = arr[end];
        arr[end] = arr[pivot];
        arr[pivot] = temp;
        return end;
    }
}
