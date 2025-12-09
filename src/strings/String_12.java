package strings;

public class String_12 {

    // Function to capitalize first letter of every word in a string
    public static String toUpperCaseWord(String str) {

        StringBuilder sb = new StringBuilder("");

        // Step 1: Convert first character to uppercase
        char firstChar = Character.toUpperCase(str.charAt(0));
        sb.append(firstChar);

        // Step 2: Loop through the remaining characters
        for (int i = 1; i < str.length(); i++) {

            // If space found and next character exists → capitalize next letter
            if (str.charAt(i) == ' ' && i < str.length() - 1) {

                sb.append(' '); // add space

                i++;  // move to the next character

                // Convert the next character to uppercase
                sb.append(Character.toUpperCase(str.charAt(i)));
            } 
            else {
                // Normal characters → add as it is
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "hi, i am vaibhav";

        String result = toUpperCaseWord(str);

        System.out.println(result);
    }
}
