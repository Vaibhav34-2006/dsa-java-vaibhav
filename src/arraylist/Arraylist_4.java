package arraylist;

import java.util.ArrayList;

public class Arraylist_4 {

    public static void main(String[] args) {

        // Create an ArrayList to store Integer values
        ArrayList<Integer> list = new ArrayList<>();

        // add() → adds elements to the ArrayList
        list.add(10);
        list.add(20);
        list.add(30);

        // Loop through the ArrayList in reverse order
        for (int i = list.size() - 1; i >= 0; i--) {

            // get(i) → fetch element at index i
            System.out.println(list.get(i));
        }

        // Print empty line for spacing
        System.out.println();
    }
}
