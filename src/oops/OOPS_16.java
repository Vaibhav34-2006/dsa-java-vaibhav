package oops;

// Parent class
class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

// Child class overriding run()
class Bike extends Vehicle {
    
    @Override
    void run() {
        System.out.println("Bike is running fast");
    }
}

public class OOPS_16 {

    public static void main(String[] args) {

        Vehicle v = new Vehicle();
        v.run();   // calls parent class method

        Bike b = new Bike();
        b.run();   // calls overridden method in Bike
    }
}
