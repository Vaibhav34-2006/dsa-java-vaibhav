package backtracking;

public class Backtracking_2 {

    // Function to find all subsets of a string
    public static void findSubsets(String str, String ans, int i) {

        //  Base case: when index reaches string length
        if (i == str.length()) {
            System.out.println(ans); // print current subset
            return;
        }

        //  Choice 1: Include current character
        findSubsets(str, ans + str.charAt(i), i + 1);

        //  Choice 2: Exclude current character
        findSubsets(str, ans, i + 1);
    }

    public static void main(String[] args) {

        String str = "abc";

        // Call subset function
        findSubsets(str, "", 0);
    }
}
