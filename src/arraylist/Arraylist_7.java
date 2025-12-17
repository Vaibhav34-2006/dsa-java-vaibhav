package arraylist;

import java.util.ArrayList;

public class Arraylist_7 {

    // Method to swap two elements in the ArrayList
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {

        // Store value at idx1 in temp variable
        int temp = list.get(idx1);

        // Replace element at idx1 with element at idx2
        list.set(idx1, list.get(idx2));

        // Put temp value at idx2
        list.set(idx2, temp);
    }

    public static void main(String[] args) {

        // Create an ArrayList to store Integer values
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add(10);
        list.add(20);
        list.add(30);

        // Indexes to be swapped
        int idx1 = 0;
        int idx2 = 2;

        // Call swap method
        swap(list, idx1, idx2);

        // Print ArrayList after swapping
        System.out.println(list);
    }
}
