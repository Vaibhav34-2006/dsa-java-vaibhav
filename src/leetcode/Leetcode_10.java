package leetcode;

import java.util.Arrays;

public class Leetcode_10 {

    // Function to merge nums2 into nums1 in sorted order
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // i -> last valid element index in nums1
        int i = m - 1;

        // j -> last element index in nums2
        int j = n - 1;

        // k -> last index in nums1 (total size - 1)
        int k = m + n - 1;

        // Merge from back so we don't overwrite nums1 values
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Copy remaining nums2 elements if any
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        // Merge arrays
        merge(nums1, m, nums2, n);

        // Print result
        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }
}
