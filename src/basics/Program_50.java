package basics;

public class Programm_50 {

    // convert decimal to binary
    public static void dectobin(int n) {
        int myNum = n;
        int pow = 0;
        int binNum = 0;

        while (n > 0) {
            int rem = n % 2;                 // remainder (0 or 1)
            binNum = binNum + rem * (int)Math.pow(10, pow);
            pow++;
            n = n / 2;                       // divide by 2
        }

        System.out.println("Binary of " + myNum + " = " + binNum);
    }

    // convert binary to decimal
    public static void bintodec (int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;

        while (binNum > 0) {
            int lastdigit = binNum % 10;
            decNum = decNum + (lastdigit * (int)Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }
        System.out.println("Decimal of " + myNum + " = " + decNum);
    }

    public static void main(String[] args) {

        // decimal to binary
        dectobin(18);

        // binary to decimal
        bintodec(10101000);
    }
}
