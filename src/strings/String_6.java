package strings;

public class String_6 {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {

        int n = str.length();  // length of string

        // Loop only till half
        for (int i = 0; i < n / 2; i++) {

            // Compare characters from front and back
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;   // Not a palindrome
            }
        }

        return true; // If no mismatch found
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str)); // true
    }
}
