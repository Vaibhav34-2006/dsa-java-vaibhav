package recursion;

public class Recursion_14 {

    // Function to print all binary strings of length n without consecutive 1s
    public static void printBinStrings(int n, int lastPlace, String str) {

        // BASE CASE
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // ---- WORK ----

        // Option 1 → always place '0'
        printBinStrings(n - 1, 0, str + "0");

        // Option 2 → place '1' ONLY IF last digit was '0'
        if (lastPlace == 0) {
            printBinStrings(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {

        printBinStrings(3, 0, "");
    }
}
