package hashing;

import java.util.HashMap;

public class Hashing_15 {

    // -------- Function to find starting point of journey --------
    public static String getStart(HashMap<String, String> tickets) {

        // Reverse map to store destination -> source
        HashMap<String, String> revMap = new HashMap<>();

        // Create reverse mapping
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        // Starting point is the city
        // which is never a destination
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; // starting city
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // -------- Given tickets --------
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // Find starting city
        String start = getStart(tickets);

        // -------- Print complete journey --------
        System.out.print(start);

        // Print path until no next destination exists
        while (tickets.containsKey(start)) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }
}
