package Core_Java.CoreJava;

public class Ternary_Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Using the ternary operator to find the maximum of two integers
        int max = (a > b) ? a : b;
        System.out.println("Maximum of " + a + " and " + b + " is: " + max);

        String name = "Alice";

        // Using the ternary operator to check if the name is empty
        String greeting = (name.isEmpty()) ? "Hello, Guest!" : "Hello, " + name + "!";
        System.out.println(greeting);
    }
}
