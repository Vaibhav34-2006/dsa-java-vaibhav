package oops;

class Penn {

    // private → only inside this class
    private String color;
    private int tip;

    // public getter → accessible everywhere
    public String getColor() {
        return this.color;
    }

    // public setter
    public void setColor(String newColor) {
        this.color = newColor;
    }

    // protected setter
    protected void setTip(int newTip) {
        this.tip = newTip;
    }

    // default getter (no access modifier)
    int getTip() {
        return this.tip;
    }
}

public class OOPS_3 {

    public static void main(String[] args) {

        Penn p1 = new Penn();   // ✔ Correct class name

        p1.setColor("Blue"); // public method
        p1.setTip(5);        // protected method

        System.out.println("Color: " + p1.getColor());
        System.out.println("Tip Size: " + p1.getTip());
    }
}
