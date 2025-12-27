package heaps;

import java.util.ArrayList;

public class Heap_3 {

    // ---------- HEAP CLASS ----------
    static class Heap {

        // ArrayList to store heap elements
        ArrayList<Integer> arr = new ArrayList<>();

        // ---------- ADD ELEMENT (INSERT) ----------
        public void add(int data) {

            // 1️ Add element at the end
            arr.add(data);

            // 2️ Fix heap property (heapify up)
            int x = arr.size() - 1;     // child index
            int par = (x - 1) / 2;      // parent index

            // Min Heap condition
            while (x > 0 && arr.get(x) < arr.get(par)) {

                // Swap child and parent
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // Move up
                x = par;
                par = (x - 1) / 2;
            }
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

        // Final heap array
        h.printHeap();
    }
}
