package oops;

// Abstract class
abstract class Animals {

    // abstract method → must be overridden
    abstract void sound();

    // normal method
    void eat() {
        System.out.println("Animals eat food");
    }
}

// Child class
class Dogs extends Animals {

    @Override
    void sound() {
        System.out.println("Dogs bark");
    }
}

public class OOPS_17 {

    public static void main(String[] args) {

        // Animals a = new Animals();  ❌ Not allowed (abstract)

        Dogs d = new Dogs();   // ✔ allowed
        d.sound();             // overridden method
        d.eat();               // inherited method
    }
}
