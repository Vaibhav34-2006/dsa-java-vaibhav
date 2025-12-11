package oops;

// Interface
interface Shape {
    void draw();      // abstract method
}

// First class implementing interface
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Second class implementing interface
class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class OOPS_18 {
    public static void main(String[] args) {

        Shape s1 = new Circle();
        s1.draw();

        Shape s2 = new Square();
        s2.draw();
    }
}
