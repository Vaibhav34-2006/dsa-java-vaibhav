package arrays;

public class Array_4 {

    // Linear Search Function
    // This method searches for 'key' inside the array 'numbers'
    public static int linearsearch(int numbers[], int key) {

        // Loop through the entire array
        for (int i = 0; i < numbers.length; i++) {

            // If current element matches the key
            if (numbers[i] == key) { 
                return i;  // return its index (position)
            }
        }

        // If key is not found, return -1
        return -1;
    }

    public static void main(String[] args) {

        // Array elements
        int numbers[] = {2, 4, 6, 8, 10};

        // Element to search
        int key = 10;

        // Calling the linear search function
        int index = linearsearch(numbers, key);

        // Checking the result
        if (index == -1) {
            System.out.println("Key not found.");   // If index = -1
        } else {
            System.out.println("Key is at index: " + index);  // If key found
        }
    }
}
