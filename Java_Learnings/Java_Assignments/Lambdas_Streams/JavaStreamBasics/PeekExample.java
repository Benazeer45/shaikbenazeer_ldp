package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekExample {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        );

        // Increment salary and print before collecting to list
        List<Employee> updatedSalaries = empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .collect(Collectors.toList());

        updatedSalaries.forEach(System.out::println);
    }
}

