package arrays;

public class Array_6 {

    // Binary Search function
    public static int binarysearch(int numbers[], int key) {

        int start = 0;                           // starting index
        int end = numbers.length - 1;            // ending index

        // loop until start crosses end
        while (start <= end) {

            int mid = (start + end) / 2;         // middle index

            // If middle element is equal to key → found
            if (numbers[mid] == key) {
                return mid;
            }

            // If key is greater → search in right half
            if (numbers[mid] < key) {
                start = mid + 1;
            }

            // If key is smaller → search in left half
            else {
                end = mid - 1;
            }
        }

        return -1;   // key not found
    }

    public static void main(String[] args) {

        int numbers[] = {2, 4, 6, 8, 10, 12};  // sorted array
        int key = 10;                         // element to search

        // calling binary search and printing result
        int index = binarysearch(numbers, key);

        if (index == -1) {
            System.out.println("Key not found.");
        } else {
            System.out.println("Key found at index: " + index);
        }
    }
}
