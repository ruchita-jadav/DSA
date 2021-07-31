package org.github.dsa.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,7,1,4,3};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void bubbleSort(int[] arr) {
        boolean swap = true;
        int lastIndex = arr.length-1;
        while(swap){
            System.out.println("inside while loop");
            swap = false;
            for( int i = 0 ; i < lastIndex ; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swap = true;
                }
            }
            lastIndex--;
        }
    }
}
