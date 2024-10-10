package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.Arrays;
import java.util.List;

public class FindFirstExample {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        );

        // Finding the first employee with salary greater than 100000
        Employee firstEmployee = empList.stream()
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);

        System.out.println(firstEmployee);
    }
}

