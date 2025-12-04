package basics;

public class Program_8 {

    public static void main(String[] args) {
        
        // Type Conversion (Automatic)
        int a = 10;
        double b = a; // int -> double
        System.out.println("Type Conversion: " + b);

        // Type Casting (Manual)
        double x = 9.5;
        int y = (int) x; // double -> int
        System.out.println("Type Casting: " + y);

        // Type Promotion in Expression
        byte p = 5;
        byte q = 10;
        int r = p + q; // byte + byte -> int
        System.out.println("Type Promotion: " + r);
    }
}
