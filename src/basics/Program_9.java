package basics;

public class Program_9 {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        // ---- Binary Operations ----
        System.out.println(a + b); // Addition
        System.out.println(a - b); // Subtraction
        System.out.println(a * b); // Multiplication
        System.out.println(a / b); // Division
        System.out.println(a % b); // Modulus (Remainder)

        // ---- Unary Operations ----
        int x = 10;

        System.out.println(+x);   // Unary plus
        System.out.println(-x);   // Unary minus
        System.out.println(++x);  // Pre-increment (increase first)
        System.out.println(x++);  // Post-increment (use first, then increase)
        System.out.println(--x);  // Pre-decrement (decrease first)
        System.out.println(x--);  // Post-decrement (use first, then decrease)

        boolean flag = true;
        System.out.println(!flag); // Logical NOT
    }
}
