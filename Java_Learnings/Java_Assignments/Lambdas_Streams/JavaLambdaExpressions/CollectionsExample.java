package Java_Assignments.Lambdas_Streams.JavaLambdaExpressions;


import java.util.ArrayList;
import java.util.List;

public class CollectionsExample {
    public static void runExample() {
        // Prepare a list of strings
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("html");
        list.add("python");

        // Print the list using a lambda expression
        list.forEach(i -> System.out.println(i));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        System.out.println(numbers);

        // Filter the list using a lambda expression
        numbers.removeIf(n -> n % 2 != 0);
        System.out.println(numbers);
    }
}
