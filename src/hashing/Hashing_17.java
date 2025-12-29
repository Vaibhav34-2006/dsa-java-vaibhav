package hashing;

import java.util.HashMap;

public class Hashing_17 {

    public static void main(String[] args) {

        // Given array
        int arr[] = {10, 2, -2, -20, 10};

        // Target sum
        int k = -10;

        // HashMap to store (prefixSum, count of that sum)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case:
        // prefix sum 0 has occurred once
        map.put(0, 1);

        int sum = 0;   // prefix sum
        int ans = 0;   // total subarrays with sum = k

        // Traverse array
        for (int j = 0; j < arr.length; j++) {

            // Add current element to prefix sum
            sum += arr[j];

            // If (sum - k) exists in map,
            // then a subarray with sum k exists
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            // Store/update current prefix sum frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Print total count of subarrays
        System.out.println(ans);
    }
}
