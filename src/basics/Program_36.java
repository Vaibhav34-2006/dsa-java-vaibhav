package basics;

public class Program_36 {

    public static void main(String[] args) {
        
        char ch = 'A';   // starting letter

        for (int i = 1; i <= 4; i++) {          // rows
            for (int j = 1; j <= i; j++) {      // columns
                System.out.print(ch + " ");
                ch++;                           // move to next alphabet
            }
            System.out.println();               // next line
        }
    }
}
