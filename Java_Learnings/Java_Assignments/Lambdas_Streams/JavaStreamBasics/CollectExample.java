package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        );

        // Collecting stream to a List
        List<Employee> collectedList = empList.stream().collect(Collectors.toList());
        collectedList.forEach(System.out::println);
    }
}

