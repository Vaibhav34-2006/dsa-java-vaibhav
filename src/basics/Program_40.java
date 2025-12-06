package basics;

public class Program_40 {

    // swap function (call by value)
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("Inside swap: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {

        int x = 5;
        int y = 10;

        System.out.println("Before swap: x = " + x + ", y = " + y);

        swap(x, y);   // call by value

        System.out.println("After swap: x = " + x + ", y = " + y);
    }
}
