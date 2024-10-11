package Java_Assignments.Lambdas_Streams.EmployeeStreamOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreamOperations {
    public static void main(String[] args) {
        List<Employee1> empList = Arrays.asList(
                new Employee1(1, "Bill Gates", 300000.0),
                new Employee1(2, "Jeff Bezos", 290000.0),
                new Employee1(3, "Mark Zuckerberg", 280000.0),
                new Employee1(1, "Bill Gates", 300000.0)  // Duplicate for testing distinct
        );

        // Sorted operation
        List<Employee1> sortedEmployees = empList.stream()
                .sorted(Comparator.comparing(Employee1::getName))
                .collect(Collectors.toList());

        System.out.println("Sorted Employees:");
        sortedEmployees.forEach(System.out::println);

        // Min operation
        Employee1 minSalaryEmployee = empList.stream()
                .min(Comparator.comparing(Employee1::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Employee with Minimum Salary: " + minSalaryEmployee);

        // Max operation
        Employee1 maxSalaryEmployee = empList.stream()
                .max(Comparator.comparing(Employee1::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Employee with Maximum Salary: " + maxSalaryEmployee);

        // Distinct operation
        List<Employee1> distinctEmployees = empList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct Employees:");
        distinctEmployees.forEach(System.out::println);

        // Match operations
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean anyEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        System.out.println("All even: " + allEven);
        System.out.println("Any even: " + anyEven);
        System.out.println("None multiple of three: " + noneMultipleOfThree);
    }
}

