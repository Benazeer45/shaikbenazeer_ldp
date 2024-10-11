package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {
        Integer[] empIds = { 1, 2, 3 };

        // Simulated employee repository
        Employee[] employees = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> employeeList = Stream.of(empIds)
                .map(id -> Arrays.stream(employees).filter(emp -> emp.id == id).findFirst().orElse(null))
                .collect(Collectors.toList());

        employeeList.forEach(System.out::println);
    }
}

