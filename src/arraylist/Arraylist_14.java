package arraylist;

import java.util.ArrayList;

public class Arraylist_14 {

    // Function to check if a pair with given sum exists
    // Works for SORTED & ROTATED ArrayList
    public static boolean pairSum2(ArrayList<Integer> list, int target) {

        int n = list.size();

        // Step 1: Find breaking point (largest element index)
        // Breaking point = index where next element is smaller
        int bp = -1;
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        // Left pointer → smallest element
        int lp = (bp + 1) % n;

        // Right pointer → largest element
        int rp = bp;

        // Step 2: Two pointer traversal (circular)
        while (lp != rp) {

            // Case 1: Pair sum equals target
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // Case 2: Pair sum less than target → move left pointer forward
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            }
            // Case 3: Pair sum greater than target → move right pointer backward
            else {
                rp = (n + rp - 1) % n;
            }
        }

        // No such pair found
        return false;
    }

    public static void main(String[] args) {

        // Create ArrayList (Sorted & Rotated)
        // Original sorted array: 6 8 9 10 11 15
        // Rotated version:
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        // Target sum
        int target = 16;

        // Function call
        System.out.println(pairSum2(list, target));
    }
}
