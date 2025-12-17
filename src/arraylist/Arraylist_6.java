package arraylist;

import java.util.ArrayList;

public class Arraylist_6 {

    public static void main(String[] args) {

        // Create an ArrayList to store Integer values
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add(10);
        list.add(20);
        list.add(30);

        // Initialize min with the maximum possible integer value
        int min = Integer.MAX_VALUE;

        // Loop through the ArrayList to find the minimum element
        for (int i = 0; i < list.size(); i++) {

            // If current element is smaller than min, update min
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }

        // Print the minimum value
        System.out.println("Minimum element is: " + min);
    }
}
