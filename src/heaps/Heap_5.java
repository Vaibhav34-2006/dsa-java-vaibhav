package heaps;

import java.util.ArrayList;

public class Heap_5 {

    // ---------- HEAP CLASS ----------
    // Implements a MIN HEAP using ArrayList
    static class Heap {

        // ArrayList to store heap elements
        ArrayList<Integer> arr = new ArrayList<>();

        // ---------- ADD (INSERT INTO HEAP) ----------
        public void add(int data) {

            // Step 1: Add element at the last index
            arr.add(data);

            // Step 2: Heapify Up
            int i = arr.size() - 1;     // index of newly added element
            int par = (i - 1) / 2;      // parent index

            // MIN HEAP CONDITION:
            // if parent > child, swap
            while (i > 0 && arr.get(par) > arr.get(i)) {

                // Swap parent and child
                int temp = arr.get(i);
                arr.set(i, arr.get(par));
                arr.set(par, temp);

                // Move up in the heap
                i = par;
                par = (i - 1) / 2;
            }
        }

        // ---------- PEEK ----------
        // Returns the minimum element of the heap
        // Time Complexity: O(1)
        public int peek() {
            return arr.get(0);   // root element
        }

        // ---------- REMOVE (DELETE MIN ELEMENT) ----------
        // Removes and returns the minimum element
        // Time Complexity: O(log n)
        public int remove() {

            // Store the minimum element
            int data = arr.get(0);

            // Step 1: Swap first and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2: Remove last element
            arr.remove(arr.size() - 1);

            // Step 3: Restore heap property (heapify down)
            heapify(0);

            return data;
        }

        // ---------- HEAPIFY (DOWN) ----------
        // Restores MIN HEAP property starting from index i
        private void heapify(int i) {

            int left = 2 * i + 1;     // left child index
            int right = 2 * i + 2;    // right child index
            int minIdx = i;           // assume current index is smallest

            // Compare parent with left child
            // If parent > left child, update minIdx
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            // Compare current minimum with right child
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            // If smallest is not parent, swap and continue heapify
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // Recursively heapify the affected subtree
                heapify(minIdx);
            }
        }

        // ---------- IS EMPTY ----------
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        Heap h = new Heap();

        // Insert elements into heap
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        // Remove elements one by one (ascending order)
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
