package recursion;

public class Recursion_4 {

    // Function to calculate sum of first n natural numbers using recursion
    public static int calcsum(int n) {

        // Base case: when n = 1, sum = 1
        if (n == 1) {
            return 1;
        }

        // Recursive call: sum of (n-1)
        int Snm1 = calcsum(n - 1);   // this gives 1 + 2 + ... + (n-1)

        // Work: add current number n to previous sum
        int Sn = n + Snm1;

        return Sn; // return total sum till n
    }

    public static void main(String[] args) {

        int n = 5;

        // Print the sum of first n natural numbers
        System.out.println(calcsum(n));  // Output: 15
    }
}
