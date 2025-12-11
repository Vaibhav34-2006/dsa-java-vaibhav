package oops;

class Student {

    // private data → hidden
    private String name;
    private int marks;

    // public method to set data (NOT a getter/setter format)
    public void enterDetails(String n, int m) {
        name = n;
        marks = m;
    }

    // public method to display data
    public void showDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class OOPS_4 {

    public static void main(String[] args) {

        Student s = new Student();

        s.enterDetails("John", 85);  // public method
        s.showDetails();             // public method
    }
}
