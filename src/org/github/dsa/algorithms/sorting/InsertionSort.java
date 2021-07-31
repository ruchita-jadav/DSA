package org.github.dsa.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * This is best approach.
     * Counter is to check loop count.
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        int counter = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                counter++;
//                if(arr[j] < arr[j-1]){
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
//                }else {
//                    break;
//                }
            }
        }
        System.out.println("insertionSort- " + counter);
    }

    private static void insertionSortOptimizedMyway(int[] arr) {
        int loop1Counter = 0;
        int loop2Counter = 0;
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            // This change will not be good if array is optimized. Best scenario complexity = O(n).
            int j = i - 1;
            for (; j >= 0; j--) {
                loop1Counter++;
                if (arr[j] < element) {
                    j++;
                    break;
                }
            }
            for (int k = i; k > j; k--) {
                loop2Counter++;
                arr[k] = arr[k - 1];
            }
            arr[j] = element;
        }
        System.out.println("selectionSortOptimized- " + loop1Counter + " " + loop2Counter);
    }

    private static void insertionSortMyway(int[] arr) {
        int loop1Counter = 0;
        int loop2Counter = 0;
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = 0;
            for (; j < i && arr[j] < element; j++) {
                loop1Counter++;
            }
            for (int k = i; k > j; k--) {
                loop2Counter++;
                arr[k] = arr[k - 1];
            }
            arr[j] = element;
        }
        System.out.println("selectionSort- " + loop1Counter + " " + loop2Counter);
    }
}
