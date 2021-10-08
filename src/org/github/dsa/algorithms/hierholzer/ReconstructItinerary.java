package org.github.dsa.algorithms.hierholzer;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary
 */
public class ReconstructItinerary {
    // origin -> list of destinations
    HashMap<String, PriorityQueue<String>> flightMap ;

    LinkedList<String> result ;

    public List<String> findItinerary(List<List<String>> tickets) {
        flightMap = new HashMap<>();
        Comparator<String> comparator = String::compareTo;


        // Step 1). build the graph first
        // Step 2). order the destinations
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            PriorityQueue<String> destList = flightMap.getOrDefault(origin, new PriorityQueue<>(String::compareTo));
            destList.offer(dest);
            this.flightMap.put(origin, destList);
        }

        this.result = new LinkedList<>();
        // Step 3). post-order DFS
        this.DFS("JFK");
        return this.result;
    }

    protected void DFS(String origin) {
        // Visit all the outgoing edges first.
        PriorityQueue<String> destList = this.flightMap.getOrDefault(origin,new PriorityQueue<>());
        while (!destList.isEmpty()) {
            // while we visit the edge, we trim it off from graph.
            String dest = destList.poll();
            DFS(dest);
        }
        // add the airport to the head of the itinerary
        this.result.offerFirst(origin);
    }
}

