package heaps;

public class Heap_7 {

    // ---------- HEAP SORT (MIN HEAP) ----------
    public static void heapSort(int arr[]) {

        int n = arr.length;

        // STEP 1️: Build Min Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // STEP 2️: Move smallest to end
        for (int i = n - 1; i > 0; i--) {

            // Swap root (smallest) with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, 0, i);
        }
    }

    // ---------- HEAPIFY (MIN HEAP) ----------
    public static void heapify(int arr[], int i, int size) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        // Compare with left child
        if (left < size && arr[left] < arr[minIdx]) {
            minIdx = left;
        }

        // Compare with right child
        if (right < size && arr[right] < arr[minIdx]) {
            minIdx = right;
        }

        // If root is not smallest
        if (minIdx != i) {

            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            // Heapify affected subtree
            heapify(arr, minIdx, size);
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int arr[] = {1, 2, 4, 5, 3};

        heapSort(arr);

        // Print sorted array (Descending order)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
