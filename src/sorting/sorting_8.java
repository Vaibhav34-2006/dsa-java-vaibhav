package sorting;

public class sorting_8 {

    // Function to print array elements
    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void countingsort(int arr[]) {

        // 1️⃣ Find the largest element (max value)
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // 2️⃣ Create counting array size = largest + 1
        int count[] = new int[largest + 1];

        // 3️⃣ Store frequency of each number
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // 4️⃣ Rebuild final sorted array
        int j = 0;  // index for original array

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 3, 2};

        countingsort(arr);   // Sort array

        printarr(arr);       // Print sorted array
    }
}
