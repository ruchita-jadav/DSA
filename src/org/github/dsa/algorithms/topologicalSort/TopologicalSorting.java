package org.github.dsa.algorithms.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TopologicalSorting {
    public static void main(String[] args) {
        int[] jobs = {1, 2, 3, 4, 5};
        // { x , y } -> x jobNumber is prerequisite for y jobNumber.
        int[][] prerequisites = new int[][]{
                {2, 3},
                {5, 3},
                {1, 4},
                {4, 2},
                {4, 5},
//                {5,1},
//                {3,1}
        };
        jobs = new TopologicalSorting().getOrderedJobs(jobs, prerequisites);
        Arrays.stream(jobs).forEach(System.out::println);
    }

    List<Integer> orderedJobs;

    private int[] getOrderedJobs(int[] jobs, int[][] prerequisites) {
        JobGraph jobGraph = createJobGraph(jobs, prerequisites);
        orderedJobs = new ArrayList<>();
        for (int i : jobs) {
            JobNode node = jobGraph.jobNodeHashMap.get(i);
            if (dFS(node)) {
                return new int[0];
            }
        }
        return orderedJobs.stream().mapToInt(x -> x).toArray();
    }

    private boolean dFS(JobNode node) {
        if (node.visited)
            return false;
        if (node.visiting)
            return true;
        node.visiting = true;
        for (JobNode jobNode : node.prerequisite) {
            if (dFS(jobNode)) {
                return true;
            }
        }
        orderedJobs.add(node.jobNumber);
        node.visited = true;
        node.visiting = false;
        return false;
    }

    private JobGraph createJobGraph(int[] jobs, int[][] prerequisites) {
        JobGraph jobGraph = new JobGraph(jobs);
        for (int i = 0; i < prerequisites.length; i++) {
            jobGraph.jobNodeHashMap.get(prerequisites[i][1]).prerequisite.add(
                    jobGraph.jobNodeHashMap.get(prerequisites[i][0]));
        }
        return jobGraph;
    }
}
