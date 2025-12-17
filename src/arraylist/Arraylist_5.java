package arraylist;

import java.util.ArrayList;

public class Arraylist_5 {

    public static void main(String[] args) {

        // Create an ArrayList to store Integer values
        ArrayList<Integer> list = new ArrayList<>();

        // add() → adds elements to the ArrayList
        list.add(10);
        list.add(20);
        list.add(30);

        // Initialize max with the smallest possible integer value
        int max = Integer.MIN_VALUE;

        // Loop through the ArrayList to find the maximum element
        for (int i = 0; i < list.size(); i++) {

            // Compare current element with max
            if (max < list.get(i)) {
                max = list.get(i); // update max
            }
        }

        // Print the maximum value
        System.out.println("Maximum element is: " + max);
    }
}
