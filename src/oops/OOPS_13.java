package oops;

class GrandParent {
    void method1() {
        System.out.println("I am GrandParent");
    }
}

class Parents extends GrandParent {   // Parents inherits GrandParent
    void method2() {
        System.out.println("I am Parents");
    }
}

class Childs extends Parents {        // Childs inherits Parents
    void method3() {
        System.out.println("I am Childs");
    }
}

public class OOPS_13 {
    public static void main(String[] args) {

        Childs c = new Childs();

        c.method1(); // from GrandParent
        c.method2(); // from Parents
        c.method3(); // from Childs
    }
}
