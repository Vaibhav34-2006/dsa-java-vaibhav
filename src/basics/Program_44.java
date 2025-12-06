package basics;

public class Program_44 {

    // function 1 → no parameters
    static void show() {
        System.out.println("Hello, this is show() with NO parameters");
    }

    // function 2 → same name but with 1 parameter
    static void show(int a) {
        System.out.println("Value = " + a);
    }

    // function 3 → same name but with 2 parameters
    static void show(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    public static void main(String[] args) {
        show();           // calls function with no parameters
        show(10);         // calls function with 1 parameter
        show(5, 15);      // calls function with 2 parameters
    }
}
