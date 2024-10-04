package Core_Java.CoreJava;

class MyClass {
    int value;

    // Constructor to initialize value
    MyClass(int value) {
        this.value = value;
    }
}

public class Passing_By_Value {

    // Method to demonstrate passing an int
    public static void changeInt(int number) {
        number = 20; // Modifying the local copy
        System.out.println("Inside changeInt: " + number);
    }

    // Method to demonstrate passing a String
    public static void changeString(String text) {
        text = "Changed"; // Modifying the local copy
        System.out.println("Inside changeString: " + text);
    }

    // Method to demonstrate passing an object
    public static void changeObject(MyClass obj) {
        obj.value = 50; // Modifying the object's attribute
        System.out.println("Inside changeObject: " + obj.value);
    }

    public static void main(String[] args) {
        // Demonstrating passing an int
        int num = 10;
        System.out.println("Before changeInt: " + num);
        changeInt(num);
        System.out.println("After changeInt: " + num);

        // Demonstrating passing a String
        String str = "Original";
        System.out.println("Before changeString: " + str);
        changeString(str);
        System.out.println("After changeString: " + str);

        // Demonstrating passing an object
        MyClass myObject = new MyClass(30);
        System.out.println("Before changeObject: " + myObject.value);
        changeObject(myObject);
        System.out.println("After changeObject: " + myObject.value);
    }
}
