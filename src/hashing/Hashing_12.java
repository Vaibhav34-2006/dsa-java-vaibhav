package hashing;

import java.util.TreeSet;

public class Hashing_12 {

    public static void main(String[] args) {

        // -------- Create TreeSet --------
        // TreeSet stores UNIQUE elements in SORTED order
        TreeSet<String> ts = new TreeSet<>();

        // -------- Add elements --------
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bengaluru");

        // -------- Print TreeSet --------
        // Output will be in alphabetical (sorted) order
        System.out.println(ts);
    }
}
