package hashing;

import java.util.HashMap;

public class Hashing_1 {

    public static void main(String[] args) {

        // -------- Create HashMap --------
        // Key   -> String (Country name)
        // Value -> Integer (Population or any numeric data)
        HashMap<String, Integer> hm = new HashMap<>();

        // -------- Insert elements --------
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        // -------- Print HashMap --------
        // Order is NOT guaranteed in HashMap
        System.out.println(hm);
    }
}
