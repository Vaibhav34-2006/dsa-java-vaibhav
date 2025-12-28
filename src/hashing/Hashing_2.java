package hashing;

import java.util.HashMap;

public class Hashing_2 {

    public static void main(String[] args) {

        // -------- Create HashMap --------
        HashMap<String, Integer> hm = new HashMap<>();

        // -------- Insert elements --------
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        // -------- Get value (O(1)) --------
        int population = hm.get("India");
        System.out.println(population);     // 100

        // If key does not exist, get() returns null
        System.out.println(hm.get("Indonesia")); // null

        // -------- containsKey (O(1)) --------
        System.out.println(hm.containsKey("India"));      // true
        System.out.println(hm.containsKey("Indonesia"));  // false

        // -------- Remove --------
        // remove() returns the value of removed key
        System.out.println(hm.remove("China")); // 150
        System.out.println(hm);                 // remaining entries

        // -------- Size --------
        System.out.println(hm.size()); // number of key-value pairs

        // -------- Is Empty --------
        hm.clear(); // removes all entries
        System.out.println(hm.isEmpty()); // true
    }
}
