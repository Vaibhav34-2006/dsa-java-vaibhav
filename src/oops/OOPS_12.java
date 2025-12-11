package oops;

class Parent {
    void show() {
        System.out.println("This is the Parent class");
    }
}

class Child extends Parent {   // Single-level inheritance
    void display() {
        System.out.println("This is the Child class");
    }
}

public class OOPS_12 {
    public static void main(String[] args) {

        Child c = new Child();
        c.show();     // inherited from Parent
        c.display();  // Child's own method
    }
}
