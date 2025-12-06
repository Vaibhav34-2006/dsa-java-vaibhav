package basics;

public class Program_45 {

    // Overloading by different NUMBER of parameters
    static void display(int a) {
        System.out.println("Integer value: " + a);
    }

    static void display(int a, int b) {
        System.out.println("Sum of two integers: " + (a + b));
    }

    // Overloading by different DATA TYPES
    static void display(double a) {
        System.out.println("Double value: " + a);
    }

    static void display(String s) {
        System.out.println("String value: " + s);
    }

    public static void main(String[] args) {

        display(10);         // calls int version
        display(10, 20);     // calls 2-int version
        display(3.14);       // calls double version
        display("Hello");    // calls String version
    }
}
