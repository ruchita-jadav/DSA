package org.github.dsa.algorithms.sorting;

import java.util.*;
/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * [3,2,1,3,4,1,2,3,1,2,2,3]
 * 3
 */
public class BucketSorting {
    public static void main(String[] args) {
        int[] input = {3,2,1,3,4,1,2,3,1,2,2,3};
        int[] res = new BucketSorting().topKFrequent(input,3);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numFreqMap = new HashMap<>();
        TreeMap<Integer, Set<Integer>> freqSetMap = new TreeMap<>(Comparator.reverseOrder());
        for (int num : nums) {
            int freq = numFreqMap.getOrDefault(num, 0);
            numFreqMap.put(num, freq + 1);
            // other map update
            if (freq != 0) {
                Set<Integer> numSet = freqSetMap.get(freq);
                numSet.remove(num);
            }
            Set<Integer> numSet = freqSetMap.getOrDefault(freq + 1, new HashSet<Integer>());
            numSet.add(num);
            freqSetMap.put(freq + 1, numSet);
        }
        int[] output = new int[k];
        int index = 0;
        for (Integer freq : freqSetMap.keySet()) {
            for (Integer key : freqSetMap.get(freq)) {
                if (index == k) {
                    return output;
                }
                output[index++] = key;
            }
        }
        return output;
    }
}
