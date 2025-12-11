package oops;

class Person {        
	public String name = "John";          // public variable
	private int age = 25;                 // private variable
	protected String city = "Mumbai";     // protected variable
	String hobby = "Reading";             // default variable

    // public method
    public void showName() {
        System.out.println("Name: " + name);
    }

    // private method
    private void showAge() {
        System.out.println("Age: " + age);
    }

    // protected method
    protected void showCity() {
        System.out.println("City: " + city);
    }

    // default method
    void showHobby() {
        System.out.println("Hobby: " + hobby);
    }

    // public method to call private method
    public void accessPrivate() {
        showAge();
    }
}

public class OOPS_2 {
    public static void main(String[] args) {

        Person p = new Person();

        // PUBLIC → accessible everywhere
        p.showName();

        // PRIVATE → NOT accessible directly
        // p.showAge();   ERROR
        p.accessPrivate();  // private accessed via public method

        // PROTECTED → accessible in same package
        p.showCity();

        // DEFAULT → accessible in same package
        p.showHobby();
    }
}
