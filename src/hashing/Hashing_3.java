package hashing;

import java.util.HashMap;
import java.util.Set;

public class Hashing_3 {

    public static void main(String[] args) {

        // -------- Create HashMap --------
        HashMap<String, Integer> hm = new HashMap<>();

        // -------- Insert key-value pairs --------
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // -------- Iterate using keySet() --------
        // keySet() returns a Set of all keys
        Set<String> keys = hm.keySet();

        // Print all keys
        System.out.println(keys);

        // Iterate over keys and access values using get()
        for (String k : keys) {
            System.out.println("key=" + k + ", value=" + hm.get(k));
        }
    }
}
