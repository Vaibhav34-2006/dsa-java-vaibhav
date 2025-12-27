package heaps;

import java.util.PriorityQueue;

public class Heap_8 {

    // ---------- POINT CLASS ----------
    static class Point implements Comparable<Point> {

        int x;
        int y;
        int distSq;
        int idx;   

        // Constructor
        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        // Compare based on distance from origin
        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int pts[][] = { {3, 3}, {5, -1}, {-2, 4} };
        int k = 2;

        // Min Heap based on distance
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // Add all points to heap
        for (int i = 0; i < pts.length; i++) {

            int x = pts[i][0];
            int y = pts[i][1];
            int distSq = x * x + y * y;

            pq.add(new Point(x, y, distSq, i));
        }

        // Nearest K points
        for (int i = 0; i < k; i++) {
            Point p = pq.remove();
            System.out.println(
                "Point Index: " + p.idx +
                " -> (" + p.x + ", " + p.y + ")"
            );
        }
    }
}
