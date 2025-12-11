package oops;

class Stud {

    String name;
    int age;

    // original constructor
    Stud(String n, int a) {
        name = n;
        age = a;
    }

    // copy constructor
    Stud(Stud s) {
        name = s.name;
        age = s.age;
    }
}

public class OOPS_8 {
    public static void main(String[] args) {

        Stud s1 = new Stud("John", 20);
        Stud s2 = new Stud(s1);   // copy constructor

        System.out.println(s2.name + " " + s2.age);
    }
}
