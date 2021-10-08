package org.github.dsa.algorithms.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JobGraph {
//    List<JobNode> jobNodeList;

    HashMap<Integer, JobNode> jobNodeHashMap;



    JobGraph(int[] jobs) {
        jobNodeHashMap = new HashMap<>();
//        jobNodeList = new ArrayList<>();
        for (int jobNumber : jobs) {
            jobNodeHashMap.put(jobNumber, new JobNode(jobNumber));
//            jobNodeList.add(jobNodeHashMap.get(jobNumber));
        }
    }
}
