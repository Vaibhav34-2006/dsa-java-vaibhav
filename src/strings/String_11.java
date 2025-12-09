package strings;

public class String_11 {

    public static void main(String[] args) {

        // Creating an empty StringBuilder
        // StringBuilder is used for fast string modifications
        StringBuilder sb = new StringBuilder("");

        // Loop from character 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {

            // Append current character to StringBuilder
            sb.append(ch);

            // Print the updated StringBuilder (current string)
            System.out.println(sb);

            // Print the current length of the StringBuilder
            System.out.println(sb.length());
        }
    }
}
