package hashing;

import java.util.HashSet;

public class Hashing_14 {

    public static void main(String[] args) {

        // Two input arrays
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        // HashSet to store elements
        HashSet<Integer> set = new HashSet<>();

        // ================= UNION =================
        // Add all elements of first array
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        // Add all elements of second array
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        // Size of set = number of unique elements (union)
        System.out.println("union = " + set.size());

        // ================= INTERSECTION =================
        // Clear set and add elements of first array again
        set.clear();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;

        // Check elements of second array
        for (int i = 0; i < arr2.length; i++) {

            // If element exists in set, it is common
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]); // remove to avoid duplicate counting
            }
        }

        // Count of common elements
        System.out.println("intersection = " + count);
    }
}
