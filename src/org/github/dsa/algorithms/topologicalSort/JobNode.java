package org.github.dsa.algorithms.topologicalSort;

import java.util.ArrayList;
import java.util.List;

public class JobNode {

    int jobNumber;

    List<JobNode> prerequisite;

    boolean visited;

    boolean visiting;

    public JobNode(int jobNumber) {
        this.jobNumber = jobNumber;
        prerequisite = new ArrayList<>();
        visited = false;
        visiting = false;
    }
}
