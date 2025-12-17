package arraylist;

import java.util.*;

public class Arraylist_3 {

    public static void main(String[] args) {

        // Create an ArrayList to store Integer values
        ArrayList<Integer> list = new ArrayList<>();

        // add() → adds elements to the ArrayList
        list.add(10);
        list.add(20);
        list.add(30);

        // size() → returns total number of elements in the ArrayList
        System.out.println(list.size());

        // Loop through the ArrayList using index
        for (int i = 0; i < list.size(); i++) {

            // get(i) → fetch element at index i
            System.out.println(list.get(i));
        }

        // Print empty line (just for output spacing)
        System.out.println();
    }
}
