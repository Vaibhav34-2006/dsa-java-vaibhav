package greedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithm_7 {

    public static void main(String[] args) {

        // n = number of horizontal pieces
        // m = number of vertical pieces
        int n = 4, m = 6;

        // Cost of vertical cuts (m-1 cuts)
        Integer costVer[] = {2, 1, 3, 1, 4};

        // Cost of horizontal cuts (n-1 cuts)
        Integer costHor[] = {4, 1, 2};

        // Sort both arrays in descending order
        // Greedy choice: always take the maximum cost cut first
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;   // pointers for horizontal and vertical cuts
        int hp = 1, vp = 1; // number of horizontal and vertical pieces
        int cost = 0;      // total minimum cost

        // Process both cuts while available
        while (h < costHor.length && v < costVer.length) {

            // If horizontal cut cost is greater or equal
            if (costHor[h] >= costVer[v]) {
                cost += costHor[h] * vp; // horizontal cut cost × vertical pieces
                hp++;                    // horizontal pieces increase
                h++;
            } 
            // Otherwise take vertical cut
            else {
                cost += costVer[v] * hp; // vertical cut cost × horizontal pieces
                vp++;                    // vertical pieces increase
                v++;
            }
        }

        // Remaining horizontal cuts
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // Remaining vertical cuts
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        // Print final minimum cost
        System.out.println("Min cost of cuts = " + cost);
    }
}
