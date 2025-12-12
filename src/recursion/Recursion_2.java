package recursion;

public class Recursion_2 {

    // Function to print numbers in increasing order using recursion
    public static void printInc(int n) {

        // Base condition: when n becomes 1, print it and return
        if (n == 1) {
            System.out.println(1);
            return;
        }

        // First recursive call (work happens after returning)
        printInc(n - 1);

        // Work: print the current number after all smaller numbers are printed
        System.out.println(n);
    }

    public static void main(String[] args) {

        int n = 10; // ending number

        // Call recursive function to print 1 to n
        printInc(n);
    }
}
