package oops;

class Box {
    int[] arr = {1, 2, 3};
}

public class OOPS_9 {

    public static void main(String[] args) {

        Box b1 = new Box();
        Box b2 = b1;    // shallow copy → same memory location

        b2.arr[0] = 99;

        System.out.println(b1.arr[0]); // 99 (changed in both)
    }
}
