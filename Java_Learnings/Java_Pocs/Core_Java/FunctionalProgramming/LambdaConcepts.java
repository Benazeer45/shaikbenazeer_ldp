package Core_Java.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

interface Operation {
    int apply(int a, int b);
}

public class LambdaConcepts {

    // Method demonstrating a simple lambda expression
    public static void demonstrateSimpleLambda() {
        Operation add = (a, b) -> a + b;  // Lambda expression for addition
        System.out.println("Addition: " + add.apply(5, 3)); // Output: 8
    }

    // Method demonstrating using lambda with collections
    public static void demonstrateLambdaWithCollections() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Using lambda to filter names that start with "A"
        System.out.println("Names starting with 'A':");
        names.stream()
                .filter(name -> name.startsWith("A"))  // Lambda expression for filtering
                .forEach(System.out::println); // Method reference to print each name
    }

    // Method demonstrating capturing variables
    public static void demonstrateVariableCapture() {
        int factor = 2; // Effectively final variable
        Function<Integer, Integer> multiply = x -> x * factor; // Lambda capturing 'factor'
        System.out.println("Multiplying 5 by factor 2: " + multiply.apply(5)); // Output: 10
    }

    // Method demonstrating method reference
    public static void demonstrateMethodReference() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        System.out.println("Names in uppercase:");
        names.forEach(name -> printUpperCase(name)); // Using lambda
        names.forEach(LambdaConcepts::printUpperCase); // Using method reference
    }

    // Helper method for method reference
    public static void printUpperCase(String name) {
        System.out.println(name.toUpperCase());
    }

    public static void main(String[] args) {
        System.out.println("Demonstrating Simple Lambda:");
        demonstrateSimpleLambda();

        System.out.println("\nDemonstrating Lambda with Collections:");
        demonstrateLambdaWithCollections();

        System.out.println("\nDemonstrating Variable Capture:");
        demonstrateVariableCapture();

        System.out.println("\nDemonstrating Method Reference:");
        demonstrateMethodReference();
    }
}
