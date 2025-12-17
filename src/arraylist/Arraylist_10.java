package arraylist;
import java.util.*;

public class Arraylist_10 {

    // Function to calculate maximum water that can be stored
    public static int storewater(ArrayList<Integer> height) {

        // Variable to store maximum water found so far
        int maxWater = 0;

        // Outer loop: selects the first line
        for (int i = 0; i < height.size(); i++) {

            // Inner loop: selects the second line (after i)
            for (int j = i + 1; j < height.size(); j++) {

                // Height of water = minimum of the two selected lines
                int ht = Math.min(height.get(i), height.get(j));

                // Width between the two lines
                int width = j - i;

                // Water stored between these two lines
                int currWater = ht * width;

                // Update maximum water if current is greater
                maxWater = Math.max(maxWater, currWater);
            }
        }

        // Return the maximum water that can be stored
        return maxWater;
    }

    public static void main(String[] args) {

        // Create ArrayList to store heights
        ArrayList<Integer> height = new ArrayList<>();

        // Add heights to the list
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // Print the maximum water stored
        System.out.println(storewater(height));
    }
}
