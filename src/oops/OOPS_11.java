package oops;

class Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog extends Animal {   // Inheritance
    void bark() {
        System.out.println("Dog barks");
    }
}

public class OOPS_11 {
    public static void main(String[] args) {

        Dog d = new Dog();
        d.eat();   // inherited from Animal
        d.bark();  // Dog's own method
    }
}
