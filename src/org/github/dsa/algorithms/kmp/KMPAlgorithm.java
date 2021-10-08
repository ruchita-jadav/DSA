package org.github.dsa.algorithms.kmp;

public class KMPAlgorithm {

    public static void main(String[] args) {
        String s = "abcdabcdabcftfhabc";
        String p = "abc";
        new KMPAlgorithm().search(s,p);
    }

    private void search(String s, String p) {
        if (s == null || s.length() == 0) {
            return;
        }
        int[] lps = new int[p.length()];
        int j = 0, i = 1;
        lps[j] = 0;
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(j)) {
                lps[i++] = j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                    j++;
                }
            }
        }
        i = 0;
        j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j == p.length()) {
                    System.out.println("pattern found at index" + (i - j));
                    j = lps[j - 1];
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        if (j == p.length()) {
            System.out.println("pattern found at index" + (i - j));
        }
    }
}



