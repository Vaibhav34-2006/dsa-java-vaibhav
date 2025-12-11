package oops;

class Ca {

    // parameterized constructor
    Ca(String brand, int price) {
        System.out.println(brand + " - " + price);
    }
}

public class OOPS_7 {
    public static void main(String[] args) {

        Ca c = new Ca("BMW", 5000000);  // passing values
    }
}
