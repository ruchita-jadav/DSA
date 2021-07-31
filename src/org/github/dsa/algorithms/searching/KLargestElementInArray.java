package org.github.dsa.algorithms.searching;

import java.util.Arrays;

//ThreeLargestNumbers
public class KLargestElementInArray {

    // Time complexity O(n) and space complexity O (1)
    public static void main(String[] args) {
        int[] input = {1, 92, 3, 42, 5, 6, 7, 8, -9, 10};
        int[] output = findLargetstNumber(input, 5);
        Arrays.stream(output).forEach(System.out::println);
    }

    private static int[] findLargetstNumber(int[] input, int k) {
        int[] output = new int[k];
        for (int i = 0; i < input.length; i++) {
            int j = k - 1;
            for (; j >= 0; j--) {
                if (input[i] > output[j]) {
                    break;
                }
            }
            if (j >= 0) {
                for (int p = 0; p < j; p++) {
                    output[p] = output[p + 1];
                }
                output[j] = input[i];
            }
        }
        return output;
    }
}
