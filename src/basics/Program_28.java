package basics;

public class Program_28 {

    public static void main(String[] args) {
        int n = 10899;
        int rev = 0;

        while (n > 0) {
            int last = n % 10;       // get last digit
            rev = rev * 10 + last;   // add digit to reverse
            n /= 10;                 // remove last digit
        }

        System.out.println(rev); // print reversed number
    }
}
