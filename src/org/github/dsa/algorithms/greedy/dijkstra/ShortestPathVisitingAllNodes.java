package org.github.dsa.algorithms.greedy.dijkstra;

import java.util.Arrays;

/**
 * Tried with Dijkastra but didn't work
 */
public class ShortestPathVisitingAllNodes {

    boolean[] visited ;
    int[] distance ;
    int[][] graph ;
    public int shortestPathLength(int[][] graph) {
        this.graph = graph;
        distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        visited = new boolean[graph.length];

        int node = 0 ;
        distance[0] = 0 ;
        int totalDistance = 0 ;
        for (int i = 0 ; i < visited.length ; i++){
            if ( !visited[i] ){
                totalDistance++;
                totalDistance += distance[function(node)];
            }
        }

        return totalDistance;
    }

    int function(int node ){
        int prevNode = node;
        while ( node >= 0 ){
            for ( int i = 0 ; i < graph[node].length ; i++){
                int connectedNode = graph[node][i];
                // if( !visited[connectedNode] )
                // {
                if (distance[connectedNode] > distance[node] + 1 )
                    distance[connectedNode] = distance[node] + 1;
                // }
            }
            visited[node] = true;
            prevNode = node;
            node = searchNode(graph[node]);
            if (node == prevNode){
                break;
            }
        }
        return prevNode;
    }

    int searchNode(int[] interNodes){
        int minIndex = -1 ;
        for ( int i = 0 ; i < interNodes.length ; i++){
            if ( !visited[interNodes[i]] && ( minIndex == -1 ||  distance[interNodes[i]] < distance[minIndex]  )){
                minIndex = interNodes[i];
            }
        }
        return minIndex;
    }


}
