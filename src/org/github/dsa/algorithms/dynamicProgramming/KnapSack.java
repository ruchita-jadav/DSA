package org.github.dsa.algorithms.dynamicProgramming;

public class KnapSack {

    public static void main(String[] args) {
        int[] items = {1, 2, 3, 4};
        int[] profits = {2, 3, 1, 4};
        int[] weights = {4, 5, 3, 7};
        int capacity = 7;
        int result = bottomUpApproach(items, profits, weights, capacity);
        System.out.println(result);
    }

    private static int bottomUpApproach(int[] items, int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[items.length][capacity + 1];
        int row = 0;
        int col = 1;
//        dp[row][col] = Math.max(dp[row][col - 1], profits[row]);
        for (; col <= capacity; col++) {
            if (weights[row] < col) {
                dp[row][col] = profits[row];
            }
        }
        row++;
        for (; row < items.length; row++) {
            for (col = 1; col <= capacity; col++) {
                int profit1 = 0;
                if (weights[row] < col) {
                    profit1 = profits[row] + dp[row-1][col-weights[row]];
                }
                dp[row][col] = Math.max(dp[row-1][col], profit1);
            }
        }
        return dp[items.length - 1][capacity];
    }
}
