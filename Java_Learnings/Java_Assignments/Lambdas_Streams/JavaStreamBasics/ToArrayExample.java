package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.Arrays;
import java.util.List;

public class ToArrayExample {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        );

        // Converting stream to an array
        Employee[] employeesArray = empList.stream().toArray(Employee[]::new);

        System.out.println(Arrays.toString(employeesArray));
    }
}

