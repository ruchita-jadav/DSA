package org.github.dsa.algorithms.sorting;
/**
 * Algorithm is quite straightforward :
 * <p>
 * Choose a random pivot.
 * <p>
 * Use a partition algorithm to place the pivot into its perfect position pos in the sorted array,
 * move smaller elements to the left of pivot, and larger or equal ones - to the right.
 * <p>
 * Compare pos and N - k to choose the side of array to proceed recursively.
 */

import java.util.Random;

public class QuickSelect {

    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(0, size - 1, size - k);
    }
    public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */
        if (left == right) // If the list contains only one element,
            return this.nums[left];  // return that element
        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);
        pivot_index = partition(left, right, pivot_index);
        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return this.nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index - 1, k_smallest);
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }
    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;
        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }
        // 3. move pivot to its final place
        swap(store_index, right);
        return store_index;
    }


}
