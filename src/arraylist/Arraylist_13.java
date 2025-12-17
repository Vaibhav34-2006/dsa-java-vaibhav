package arraylist;
import java.util.*;

public class Arraylist_13 {

    // Function to check if any pair sum equals target
    public static boolean pairSum(ArrayList<Integer> list, int target) {

        // Outer loop picks first element
        for (int i = 0; i < list.size(); i++) {

            // Inner loop picks second element after i
            for (int j = i + 1; j < list.size(); j++) {

                // Check if pair sum equals target
                if (list.get(i) + list.get(j) == target) {
                    return true; // Pair found
                }
            }
        }

        // No such pair found
        return false;
    }

    public static void main(String[] args) {

        // Create ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Target sum
        int target = 5;

        // Function call and output
        System.out.println(pairSum(list, target));
    }
}
