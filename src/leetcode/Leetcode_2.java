package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_2 {

    // Merge two sorted lists using Java Collections Framework
    public static List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {

        // Result list using JCF
        List<Integer> merged = new ArrayList<>();

        int i = 0, j = 0;

        // Compare elements from both lists
        while (i < list1.size() && j < list2.size()) {

            if (list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements from list1
        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }

        // Add remaining elements from list2
        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }

        return merged;
    }

    public static void main(String[] args) {

        // Create first sorted list
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);

        // Create second sorted list
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);

        // Merge using JCF
        List<Integer> result = mergeTwoLists(list1, list2);

        // Print merged list
        System.out.println("Merged List: " + result);
    }
}
