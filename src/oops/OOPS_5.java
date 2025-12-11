package oops;

// Class Stu
class Stu {
    
    // Instance variables (attributes)
    String name;     // student name
    int rollno;      // student roll number

    // Constructor (automatically runs when object is created)
    Stu() {
        System.out.println("Constructor is called....");
    }
}

public class OOPS_5 {

    public static void main(String[] args) {

        // Creating object of Stu class
        Stu s1 = new Stu();   // constructor runs here
    }
}
