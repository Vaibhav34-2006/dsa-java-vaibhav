package arraylist;

import java.util.*;

public class Arraylist_8 {

    public static void main(String[] args) {

        // Create an ArrayList to store Integer values
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add(10);
        list.add(20);
        list.add(30);

        // Print original list
        System.out.println("Original List: " + list);

        // Sort list in ascending order
        Collections.sort(list);
        System.out.println("Ascending Order: " + list);

        // Sort list in descending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Descending Order: " + list);
    }
}
