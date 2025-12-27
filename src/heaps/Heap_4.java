package heaps;

import java.util.ArrayList;

public class Heap_4 {

    // ---------- HEAP CLASS ----------
    static class Heap {

        // ArrayList to store heap elements
        ArrayList<Integer> arr = new ArrayList<>();

        // ---------- ADD ELEMENT (INSERT) ----------
        public void add(int data) {

            // Add element at last index
            arr.add(data);

            // Heapify up
            int x = arr.size() - 1;   // child index
            int par = (x - 1) / 2;    // parent index

            while (x > 0 && arr.get(x) < arr.get(par)) {

                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        // ---------- PEEK ----------
        // Returns minimum element (root of Min Heap)
        public int peek() {
            return arr.get(0); // O(1)
        }

        // ---------- PRINT HEAP ----------
        public void printHeap() {
            System.out.println(arr);
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        Heap h = new Heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(7);
        h.add(2);

        // Print heap array
        h.printHeap();

        // Peek element
        System.out.println("Peek element: " + h.peek());
    }
}
