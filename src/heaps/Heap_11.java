package heaps;

import java.util.PriorityQueue;

public class Heap_11 {

    // Pair class to store value and its index
    // Implements Comparable so PriorityQueue knows how to order elements
    static class Pair implements Comparable<Pair> {
        int val;   // value of element
        int idx;   // index of element in array

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        // Max-Heap based on value
        @Override
        public int compareTo(Pair p2) {
            // descending order (bigger value comes first)
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // window size

        // result array size = n - k + 1
        int res[] = new int[arr.length - k + 1];

        // Max Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // ---------- First window ----------
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        // maximum of first window
        res[0] = pq.peek().val;

        // ---------- Remaining windows ----------
        for (int i = k; i < arr.length; i++) {

            // remove elements which are out of current window
            while (!pq.isEmpty() && pq.peek().idx <= i - k) {
                pq.remove();
            }

            // add current element
            pq.add(new Pair(arr[i], i));

            // store maximum for current window
            res[i - k + 1] = pq.peek().val;
        }

        // ---------- Print result ----------
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
