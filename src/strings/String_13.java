package strings;

public class String_13 {

    // Function to compress the string using Run-Length Encoding
    public static String compressString(String str) {

        String newStr = "";   // Stores final compressed string

        // Loop through the string
        for (int i = 0; i < str.length(); i++) {

            int count = 1;  // Count occurrences of current character

            // Count repeating consecutive characters
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;   // move ahead
            }

            // Add current character
            newStr += str.charAt(i);

            // If the character repeats more than once, add the count
            if (count > 1) {
                newStr += count;
            }
        }

        return newStr;  // return the compressed string
    }

    public static void main(String[] args) {

        String str = "aaabbcddddd";

        // Function call
        String compressed = compressString(str);

        // Output result
        System.out.println("Original : " + str);
        System.out.println("Compressed : " + compressed);
    }
}
