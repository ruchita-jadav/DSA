package org.github.dsa.algorithms.kadanes;

/**
 * To find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
 * Approach : Dynamic Programming
 *  Find max sum at current index and pass it same for next calculation.
 * Equation :
 *  Max sum of current Index = Max.of( ( Max sum of previous Index + current number) , current number)
 *
 */
public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(new KadanesAlgorithm().findMaxSumOfSubarray(arr));
    }

    private int findMaxSumOfSubarray(int[] arr) {
        int maxSum = arr[0];
        int prevSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int currentSum = prevSum + arr[i];
            System.out.print(arr[i] + " ");
            if (arr[i] > currentSum) {
                System.out.println();
                currentSum = arr[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            prevSum = currentSum;
        }
        System.out.println();
        return maxSum;
    }
}
