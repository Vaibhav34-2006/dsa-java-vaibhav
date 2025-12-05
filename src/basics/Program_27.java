package basics;

public class Program_27 {

    public static void main(String[] args) {
        int n = 10899;

        while (n > 0) {
            int lastdigit = n % 10; // print last digit
            System.out.println(lastdigit); 
            n /= 10; // remove last digit
        }
    }
}
