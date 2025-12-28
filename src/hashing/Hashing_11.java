package hashing;

import java.util.LinkedHashSet;

public class Hashing_11 {

    public static void main(String[] args) {

        // -------- Create LinkedHashSet --------
        // LinkedHashSet maintains INSERTION ORDER
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        // -------- Add elements --------
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");

        // -------- Print LinkedHashSet --------
        // Elements will be printed in insertion order
        System.out.println(lhs);
    }
}
