package hashing;

import java.util.HashMap;
import java.util.Set;

public class Hashing_7 {

    public static void main(String[] args) {

        // Given integer array
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};

        // HashMap to store frequency (count) of each number
        // key   -> array element
        // value -> how many times it appears
        HashMap<Integer, Integer> map = new HashMap<>();

        // ---------- Count frequency of each element ----------
        for (int i = 0; i < arr.length; i++) {

            // If element is already present in HashMap
            if (map.containsKey(arr[i])) {
                // Increase its count by 1
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            // If element is seen for the first time
            else {
                // Put element with count = 1
                map.put(arr[i], 1);
            }
        }

        // ---------- Find elements appearing more than n/3 times ----------
        // Get all keys from HashMap
        Set<Integer> keySet = map.keySet();

        // Traverse through each key
        for (Integer key : keySet) {

            // If frequency of key is greater than n/3
            if (map.get(key) > arr.length / 3) {

                // Print that element
                System.out.println(key);
            }
        }
    }
}
