package org.github.dsa.algorithms.searching;

public class BinarySearch {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000000);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        searchIterative(arr, -5);
        searchRecursive(arr, 0, 9, -2);
    }

    private static void searchRecursive(int[] arr, int start, int end, int element) {
        int mid = (int) Math.floor((start + end) / 2);
        if (start > end)
            return;
        if (arr[mid] == element)
            System.out.println("element " + element + " found at " + mid);
        else {
            if (element < arr[mid])
                searchRecursive(arr, start, mid - 1, element);
            else
                searchRecursive(arr, mid + 1, end, element);
        }
    }

    private static void searchIterative(int[] arr, int element) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (int) Math.floor((start + end) / 2);
            if (arr[mid] == element) {
                System.out.println("element " + element + " found at " + mid);
                break;
            } else {
                if (element < arr[mid]) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }
        }
    }
}
