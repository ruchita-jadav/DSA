package org.github.dsa.algorithms.greedy.bfs;

import java.util.*;

public class ShortestPathInUnweightedGraph {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0},
                {0},
                {0}
        };
        System.out.println(new ShortestPathInUnweightedGraph().shortestPathLength(graph));
    }




    public int shortestPathLength(int[][] graph) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        int dest = graph.length - 1;
        // As we are doing BFS so add just first node in queue.
        Node source = new Node(0, 0, true, null);
        nodeMap.putIfAbsent(source.nodeValue, source);
        queue.offer(source);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < graph[node.nodeValue].length; i++) {
                if (!nodeMap.containsKey(graph[node.nodeValue][i])) {
                    Node temp = new Node(graph[node.nodeValue][i], node.distance + 1, true, node);
                    nodeMap.put(temp.nodeValue, temp);
                    if (temp.nodeValue == dest) {
                        queue.clear();
                        break;
                    }
                    queue.offer(temp);
                }
            }
        }
        return nodeMap.get(dest).distance;
    }

    class Node {
        int nodeValue;

        int distance = Integer.MAX_VALUE;

        boolean visited = false;

        Node parent = null;

        public Node(int nodeValue, int distance, boolean visited, Node parent) {
            this.nodeValue = nodeValue;
            this.distance = distance;
            this.visited = visited;
            this.parent = parent;
        }

        public Node(int nodeValue) {
            this.nodeValue = nodeValue;
        }
    }
}
