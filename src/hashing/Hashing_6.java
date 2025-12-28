package hashing;

import java.util.HashMap;
import java.util.TreeMap;

public class Hashing_6 {

    public static void main(String[] args) {

        // -------- TreeMap --------
        // Stores keys in SORTED (alphabetical) order
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Indonesia", 6);

        // -------- HashMap --------
        // Does NOT maintain any order
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        // -------- Print --------
        System.out.println(hm);
        System.out.println(tm);
    }
}
