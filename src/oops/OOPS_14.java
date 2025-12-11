package oops;

// Parent class
class Parentss {
    void show() {
        System.out.println("I am Parentss");
    }
}

// Child1 class inherits Parentss
class Child1 extends Parentss {
    void display1() {
        System.out.println("I am Child1");
    }
}

// Child2 class also inherits Parentss
class Child2 extends Parentss {
    void display2() {
        System.out.println("I am Child2");
    }
}

public class OOPS_14 {
    public static void main(String[] args) {

        // Creating object of Child1
        Child1 c1 = new Child1();
        c1.show();       // inherited from Parentss
        c1.display1();   // Child1 method

        // Creating object of Child2
        Child2 c2 = new Child2();
        c2.show();       // inherited from Parentss
        c2.display2();   // Child2 method
    }
}
