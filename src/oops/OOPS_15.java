package oops;

// Class with method overloading
class Calculator {

    // Method 1: adds two integers
    int sum(int a, int b) {
        return a + b;
    }

    // Method 2: adds two float values (different data type)
    float sum(float a, float b) {
        return a + b;
    }

    // Method 3: adds three integers (different number of parameters)
    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

public class OOPS_15 {

    public static void main(String[] args) {

        // Creating object of Calculator
        Calculator cal = new Calculator();

        // Calling overloaded methods
        System.out.println("Sum of 2 integers: " + cal.sum(5, 10));
        System.out.println("Sum of 2 floats: " + cal.sum(2.5f, 3.5f));
        System.out.println("Sum of 3 integers: " + cal.sum(5, 10, 15));
    }
}
