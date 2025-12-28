package hashing;

import java.util.HashSet;

public class Hashing_13 {

    public static void main(String[] args) {

        // Given array with duplicate elements
        int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};

        // HashSet stores only unique elements
        HashSet<Integer> set = new HashSet<>();

        // Add all elements of array to HashSet
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);   // duplicates are ignored automatically
        }

        // Size of HashSet = number of distinct elements
        System.out.println("ans = " + set.size());
    }
}
