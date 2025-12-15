package backtracking;

public class Backtracking_3 {

    // Function to find all permutations of a string
    public static void findPermutation(String str, String ans) {

        //  Base case: when original string becomes empty
        if (str.length() == 0) {
            System.out.println(ans); // print one permutation
            return;
        }

        //  Loop to choose each character one by one
        for (int i = 0; i < str.length(); i++) {

            // Current character chosen
            char curr = str.charAt(i);

            // Remaining string after removing chosen character
            String newStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            findPermutation(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {

        String str = "abc";

        // Call permutation function
        findPermutation(str, "");
    }
}
