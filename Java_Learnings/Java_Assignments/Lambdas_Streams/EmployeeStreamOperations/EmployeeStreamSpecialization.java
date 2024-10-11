package Java_Assignments.Lambdas_Streams.EmployeeStreamOperations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeStreamSpecialization {
    public static void main(String[] args) {
        List<Employee1> empList = Arrays.asList(
                new Employee1(1, "Bill Gates", 300000.0),
                new Employee1(2, "Jeff Bezos", 290000.0),
                new Employee1(3, "Mark Zuckerberg", 280000.0)
        );

        // Using IntStream to find the maximum employee ID
        int latestEmpId = empList.stream()
                .mapToInt(Employee1::getId)
                .max()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Maximum Employee ID: " + latestEmpId);

        // Using DoubleStream to find the average salary
        OptionalDouble avgSalary = empList.stream()
                .mapToDouble(Employee1::getSalary)
                .average();

        System.out.println("Average Salary: " + (avgSalary.isPresent() ? avgSalary.getAsDouble() : "No salaries available"));

        // Using IntStream.range to create a range of numbers
        IntStream.range(10, 20).forEach(System.out::println);

        // Using reduce to calculate the total salary
        double totalSalary = empList.stream()
                .map(Employee1::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Total Salary: " + totalSalary);
    }
}

