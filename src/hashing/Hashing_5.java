package hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Hashing_5 {

    public static void main(String[] args) {

        // -------- LinkedHashMap --------
        // Maintains INSERTION ORDER
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        // -------- HashMap --------
        // Does NOT maintain insertion order
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        // -------- Print --------
        System.out.println(hm);
        System.out.println(lhm);
    }
}
