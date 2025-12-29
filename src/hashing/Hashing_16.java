package hashing;

import java.util.HashMap;

public class Hashing_16 {

    public static void main(String[] args) {

        // Given input array
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        // HashMap to store prefixSum as key and index as value
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;   // Stores prefix sum till current index
        int len = 0;   // Stores length of longest subarray with sum = 0

        // Traverse the array
        for (int j = 0; j < arr.length; j++) {

            // Add current element to prefix sum
            sum += arr[j];

            // If same prefix sum is found again
            // then subarray between indices has sum = 0
            if (map.containsKey(sum)) {

                // Update maximum length
                len = Math.max(len, j - map.get(sum));
            }
            else {
                // Store prefix sum with its first index
                map.put(sum, j);
            }
        }

        // Print final answer
        System.out.println("largest subarray with sum 0 = " + len);
    }
}
