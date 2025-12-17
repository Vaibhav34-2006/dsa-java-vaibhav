package arraylist;

import java.util.ArrayList;

public class Arraylist_9 {

    public static void main(String[] args) {

        // 2D ArrayList (ArrayList of ArrayLists)
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        // Creating inner ArrayLists
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // Adding elements to inner lists
        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);   // 1,2,3,4,5
            list2.add(i * 2);   // 2,4,6,8,10
            list3.add(i * 3);   // 3,6,9,12,15
        }

        // Adding inner lists to main list
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        // Printing using normal print
        System.out.println("Using direct print:");
        System.out.println(mainList);

        // Printing using nested loops
        System.out.println("\nUsing nested loops:");
        for (int i = 0; i < mainList.size(); i++) {          // Outer loop
            for (int j = 0; j < mainList.get(i).size(); j++) { // Inner loop
                System.out.print(mainList.get(i).get(j) + " ");
            }
            System.out.println(); // Move to next line after each row
        }
    }
}
