package heaps;

import java.util.PriorityQueue;

public class Heap_10 {

    // ---------- ROW CLASS ----------
    // Each Row object stores:
    // soldiers -> number of 1s in the row
    // idx      -> row index
    static class Row implements Comparable<Row> {

        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        // Comparison logic:
        // 1) Fewer soldiers = weaker row
        // 2) If soldiers equal, smaller index first
        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int army[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int k = 2;

        // Min Heap based on soldiers count
        PriorityQueue<Row> pq = new PriorityQueue<>();

        // Count soldiers in each row and add to heap
        for (int i = 0; i < army.length; i++) {
            int count = 0;

            for (int j = 0; j < army[0].length; j++) {
                if (army[i][j] == 1) {
                    count++;
                }
            }

            pq.add(new Row(count, i));
        }

        // Print k weakest rows
        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().idx);
        }
    }
}
