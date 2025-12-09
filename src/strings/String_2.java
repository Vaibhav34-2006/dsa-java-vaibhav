package strings;
import java.util.*;

public class String_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // next() reads only one word (stops at space)
        String name;
        System.out.print("Enter name (single word): ");
        name = sc.next();
        System.out.println("You entered: " + name);

        sc.nextLine(); 

        // nextLine() reads the entire line including spaces
        String fullName;
        System.out.print("Enter full name: ");
        fullName = sc.nextLine();
        System.out.println("Full name: " + fullName);

        sc.close();
    }
}
