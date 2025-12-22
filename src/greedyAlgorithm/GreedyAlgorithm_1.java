package greedyAlgorithm;

import java.util.ArrayList;

public class GreedyAlgorithm_1 {

    public static void main(String[] args) {

        // Start time of activities
        int start[] = {1, 3, 0, 5, 8, 5};

        // End time of activities (already sorted by end time)
        int end[] = {2, 4, 6, 7, 9, 9};

        // To store maximum number of activities selected
        int maxAct = 0;

        // List to store indices of selected activities
        ArrayList<Integer> ans = new ArrayList<>();

        // Select the first activity
        maxAct = 1;
        ans.add(0);

        // End time of last selected activity
        int lastEnd = end[0];

        // Loop through remaining activities
        for (int i = 1; i < end.length; i++) {

            // If current activity starts after or at the end of last selected activity
            if (start[i] >= lastEnd) {

                // Select the activity
                maxAct++;
                ans.add(i);

                // Update lastEnd to current activity's end time
                lastEnd = end[i];
            }
        }

        // Print maximum number of activities
        System.out.println("Max activities = " + maxAct);

        // Print selected activities
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
