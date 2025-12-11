package oops;

class Boxx {
    int[] arr = {1, 2, 3};
}

public class OOPS_10 {

    public static void main(String[] args) {

        Boxx b1 = new Boxx();

        // deep copy → new array created
        Boxx b2 = new Boxx();
        b2.arr = b1.arr.clone();

        b2.arr[0] = 99;

        System.out.println(b1.arr[0]); // 1 (no change in b1)
    }
}
