package Core_Java.ObjectOrientedProgramming;

public class Class_Method_Object {
    // Instance variables
    private int number;
    private String text;

    // Constructor
    public Class_Method_Object(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public void displayValues() {
        System.out.println("Number: " + number);
        System.out.println("Text: " + text);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static void main(String[] args) {
        // Creating an object of Class_Method_Object
        Class_Method_Object obj1 = new Class_Method_Object(5, "Hello");

        System.out.println("Initial values:");
        obj1.displayValues();

        obj1.setNumber(10);
        obj1.setText("World");

        System.out.println("\nModified values:");
        obj1.displayValues();
    }
}
