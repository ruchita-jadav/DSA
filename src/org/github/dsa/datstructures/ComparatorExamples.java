package org.github.dsa.datstructures;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3 use case :
 *
 * Want to keep duplication elements along with sorting : PriorityQueue
 *
 * Non duplicate : TreeSet
 *
 * Map : Tree Map
 *
 */
public class ComparatorExamples {

    public static void main(String[] args) {
        String s = null ;
        s.join("ruchi");
        System.out.println(s);
//        queueComparator();
    }

    private static void queueComparator() {
        Comparator<int[]> comparator = Comparator.comparingInt(x -> x[0]);
//        Comparator<int[]> comparator = (x,y ) -> x[0] - y[0] ;
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
    }
}
