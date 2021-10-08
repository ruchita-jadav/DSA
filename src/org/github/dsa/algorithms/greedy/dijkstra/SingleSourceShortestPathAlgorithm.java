package org.github.dsa.algorithms.greedy.dijkstra;

/**
 * To find the shortest paths from the source to all vertices in the graph.
 */
public class SingleSourceShortestPathAlgorithm {

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                  //
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        new SingleSourceShortestPathAlgorithm().shortestPath(graph, 0);
    }

    private int shortestPath(int[][] graph, int source) {


        return 0;
    }
}
