package org.github.dsa.algorithms.selection;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given n activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
 * <p>
 * <p>
 * Example 1 : Consider the following 3 activities sorted by
 * by finish time.
 * start[]  =  {10, 12, 20};
 * finish[] =  {20, 25, 30};
 * A person can perform at most two activities. The
 * maximum set of activities that can be executed
 * is {0, 2} [ These are indexes in start[] and
 * finish[] ]
 * <p>
 * Example 2 : Consider the following 6 activities
 * sorted by by finish time.
 * start[]  =  {1, 3, 0, 5, 8, 5};
 * finish[] =  {2, 4, 6, 7, 9, 9};
 * A person can perform at most four activities. The
 * maximum set of activities that can be executed
 * is {0, 1, 3, 4} [ These are indexes in start[] and
 * finish[] ]
 */
public class ActivityTimingSelection {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        new ActivityTimingSelection().totalActivities(start,finish);
    }
        /*
        * Solution :
            1) Sort the activities according to their finishing time
            2) Select the first activity from the sorted array and print it.
            3) Do the following for the remaining activities in the sorted array.
             …….a) If the start time of this activity is greater than or equal to the finish time of the previously selected activity then select this activity and print it.
        *
        * */
    private int totalActivities(int[] start, int[] finish) {
        int totalActivities = 0 ;
        PriorityQueue<Activity> queue = new PriorityQueue<>(Comparator.comparingInt(Activity::getFinish));
        for (int i = 0; i < start.length; i++) {
            queue.add(new Activity(start[i], finish[i]));
        }
        Activity activity;
        Activity lastActivity = null ;
        while ( !queue.isEmpty()){
             activity = queue.poll();
             if (lastActivity == null || (activity.finish > lastActivity.finish  && activity.start > lastActivity.finish ) ){
                 lastActivity = activity;
                 totalActivities++;
             }
        }
        return totalActivities;
    }

    class Activity {
        int start;

        int finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        int getFinish() {
            return finish;
        }
    }
}
