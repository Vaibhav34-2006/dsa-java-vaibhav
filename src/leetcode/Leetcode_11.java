package leetcode;

public class Leetcode_11 {

    // Function to check whether a number is palindrome
    public static boolean isPalindrome(int x) {

        // Negative numbers can never be palindrome
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        // Reverse the number digit by digit
        while (x > 0) {
            int digit = x % 10;          // get last digit
            reversed = reversed * 10 + digit;
            x = x / 10;                 // remove last digit
        }

        // Compare original number with reversed number
        return original == reversed;
    }

    public static void main(String[] args) {

        // Sample test cases
        int n1 = 121;
        int n2 = -121;
        int n3 = 10;

        // Print results
        System.out.println(n1 + " is palindrome? " + isPalindrome(n1));
        System.out.println(n2 + " is palindrome? " + isPalindrome(n2));
        System.out.println(n3 + " is palindrome? " + isPalindrome(n3));
    }
}
