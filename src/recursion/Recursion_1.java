package recursion;

// A class to demonstrate simple recursion
public class Recursion_1 {

    // Function to print numbers in decreasing order using recursion
    public static void printdec(int n) {

        // Base condition: when n becomes 1, print it and stop recursion
        if (n == 1) {
            System.out.println(n + "");
            return; // stops further function calls
        }

        // Work: print the current number
        System.out.println(n);

        // Recursive call: call the same function with (n-1)
        printdec(n - 1);
    }

    public static void main(String[] args) {

        int n = 10; // starting number

        // Call the recursive function to print numbers from 10 to 1
        printdec(n);
    }
}
