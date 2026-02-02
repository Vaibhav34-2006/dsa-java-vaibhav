package leetcode;

public class Leetcode_6 {

    // Function to convert Roman numeral string to integer
    public static int romanToInt(String s) {

        int total = 0;

        // Traverse through the string
        for (int i = 0; i < s.length(); i++) {

            int value = getValue(s.charAt(i));

            // If next character exists and is larger,
            // subtract current value
            if (i + 1 < s.length() && value < getValue(s.charAt(i + 1))) {
                total -= value;
            }
            // Otherwise add current value
            else {
                total += value;
            }
        }

        return total;
    }

    // Helper function to return numeric value of Roman symbol
    private static int getValue(char c) {

        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;

        return 0;
    }

    public static void main(String[] args) {

        // Sample test cases
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";

        // Print results
        System.out.println(s1 + " -> " + romanToInt(s1));
        System.out.println(s2 + " -> " + romanToInt(s2));
        System.out.println(s3 + " -> " + romanToInt(s3));
    }
}
