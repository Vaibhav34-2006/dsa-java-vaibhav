package Technique;

public class two_pointer {

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {

        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = twoSum(numbers, target);

        System.out.println(result[0] + " " + result[1]);
    }
}