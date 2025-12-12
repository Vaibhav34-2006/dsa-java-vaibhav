package recursion;

public class Recursion_13 {

    // Function to count number of ways n friends can remain single or pair up
    public static int friendsPairing(int n) {

        // Base cases:
        // If n = 1 → only 1 way (single)
        // If n = 2 → 2 ways (both single, or both together)
        if (n == 1 || n == 2) {
            return n;
        }

        // ---- WORK (CHOICES) ----

        // Choice 1: friend stays single → solve for n-1 people
        int single = friendsPairing(n - 1);

        // Choice 2: friend pairs up with any of (n-1) friends
        // Remaining = solve for n-2
        int pair = (n - 1) * friendsPairing(n - 2);

        // Total ways = single ways + pair ways
        return single + pair;
    }

    public static void main(String args[]) {

        System.out.println(friendsPairing(3));  // Output: 4
    }
}
