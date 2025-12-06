package basics;

public class Program_48{

    // function that prints all primes from 2 to n
    public static void printPrimes(int n) {

        System.out.println("Prime numbers from 2 to " + n + ":");

        for (int i = 2; i <= n; i++) {
            if (isprime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // prime check function
    public static boolean isprime(int n) {

        if (n == 2) return true;
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        printPrimes(50);   // only one call
    }
}
