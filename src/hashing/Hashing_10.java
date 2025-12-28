package hashing;

import java.util.HashSet;
import java.util.Iterator;

public class Hashing_10 {

    public static void main(String[] args) {

        // -------- Create HashSet --------
        HashSet<String> cities = new HashSet<>();

        // -------- Add elements --------
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        // ==================================================
        // Method 1: Iteration using Iterator
        // ==================================================

        Iterator<String> it = cities.iterator();

        // Loop until there is no next element
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // ==================================================
        // Method 2: Iteration using Enhanced for-loop
        // ==================================================

        for (String city : cities) {
            System.out.println(city);
        }
    }
}
