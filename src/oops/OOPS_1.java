package oops;

// Class (Blueprint)
class Pen {
    String color;  // property
    int tip;       // property

    // Method to set color
    void setColor(String newColor) {
        color = newColor;
    }

    // Method to set tip size
    void setTip(int newTip) {
        tip = newTip;
    }
}

public class OOPS_1 {
    public static void main(String[] args) {

        // Creating object of Pen class
        Pen p1 = new Pen();

        // Setting color and printing it
        p1.setColor("Blue");
        System.out.println(p1.color);

        // Setting tip size and printing it
        p1.setTip(5);
        System.out.println(p1.tip);
    }
}
