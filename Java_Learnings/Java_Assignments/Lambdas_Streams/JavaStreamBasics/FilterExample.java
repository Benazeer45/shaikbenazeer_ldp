package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        );

        // Filtering employees with salary greater than 200000
        List<Employee> filteredList = empList.stream()
                .filter(e -> e.getSalary() > 200000)
                .collect(Collectors.toList());

        filteredList.forEach(System.out::println);
    }
}

