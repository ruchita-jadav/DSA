package org.github.dsa.algorithms.greedy.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 *
 */
public class HuffmanCoding {

    Map<Character,Integer> codeCharMap = new HashMap<>();
    public static void main(String[] args) {
        // expecting inputs sorted as per code
        int[] frequencies = {};
        char[] chars = {3,11,19,25,32,37,41,49,54,60};
        Map<Character, Integer> input = new HashMap<>();
        input.put('c',3);
        input.put('a',11);
        input.put('a',19);
        input.put('a',25);
        input.put('a',32);
        input.put('a',37);
        input.put('a',41);
        input.put('a',49);
        input.put('a',54);
        input.put('a',60);
    }

    private void generateCode(){

    }
}
