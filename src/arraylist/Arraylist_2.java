package arraylist;

import java.util.ArrayList;

public class Arraylist_2 {

    public static void main(String[] args) {

        // Create ArrayList of Integer
        ArrayList<Integer> list = new ArrayList<>();

        // add() → add elements
        list.add(10);
        list.add(20);
        list.add(30);

        // get() → get element at index
        int value = list.get(1);   // 20

        // set() → update element
        list.set(1, 25);           // 20 → 25

        // remove() → remove element
        list.remove(0);            // removes 10

        // contains() → print result using System.out.println
        System.out.println(list.contains(30)); // true
        System.out.println(list.contains(10)); // false
    }
}
