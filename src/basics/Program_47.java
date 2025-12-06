package basics;

public class Program_47 {
    
    public static boolean isprime(int n) {

        if (n ==2) {
            return true;   
        }

        boolean isPrime = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        System.out.println(isprime(12)); // false
        System.out.println(isprime(13)); // true
    }
}
