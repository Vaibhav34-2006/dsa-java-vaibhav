package arrays;

public class Array_7 {

    // Function to reverse the array
    public static void reverse(int numbers[]) {

        int first = 0;                      // pointer at the start
        int last = numbers.length - 1;      // pointer at the end

        // run loop until both pointers meet
        while (first < last) {

            // swap elements at first and last index
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            // move pointers towards center
            first++;
            last--;
        }
    }

    public static void main(String[] args) {

        int numbers[] = {2, 4, 6, 8, 10};   // original array

        reverse(numbers);                   // reverse the array

        // print reversed array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println();
    }
}
