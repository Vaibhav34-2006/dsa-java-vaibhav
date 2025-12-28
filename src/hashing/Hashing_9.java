package hashing;

import java.util.HashSet;

public class Hashing_9 {

    public static void main(String[] args) {

        // -------- Create HashSet --------
        // HashSet stores UNIQUE elements only
        HashSet<Integer> set = new HashSet<>();

        // -------- Add elements --------
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2); // duplicate (will be ignored)
        set.add(1); // duplicate (will be ignored)

        // -------- Print HashSet --------
        // Order is NOT guaranteed
        System.out.println(set);

        // -------- Size of HashSet --------
        // Returns number of unique elements
        System.out.println(set.size());

        // -------- Clear HashSet --------
        // Removes all elements
        set.clear();

        // -------- Size after clear --------
        System.out.println(set.size());

        // -------- Check if HashSet is empty --------
        System.out.println(set.isEmpty());
    }
}
