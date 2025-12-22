package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class GreedyAlgorithm_6 {

    // Job class to store job details
    static class Job {
        int id;        // Job ID
        int deadline;  // Deadline of job
        int profit;    // Profit of job

        // Constructor
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {

        /*
         * jobsInfo[i][0] -> deadline
         * jobsInfo[i][1] -> profit
         */
        int jobsInfo[][] = {
                {4, 20},
                {1, 10},
                {1, 40},
                {1, 30}
        };

        // List to store all jobs
        ArrayList<Job> jobs = new ArrayList<>();

        // Convert jobsInfo array into Job objects
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort jobs in descending order of profit (Greedy step)
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        // To store selected job sequence
        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0; // Current time slot

        // Select jobs greedily
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);

            // If job can be completed before its deadline
            if (curr.deadline > time) {
                seq.add(curr.id); // Select job
                time++;           // Move to next time slot
            }
        }

        // Print result
        System.out.println("Max jobs = " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}
