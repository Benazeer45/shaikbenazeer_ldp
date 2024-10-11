package Java_Assignments.Lambdas_Streams.EmployeeStreamOperations;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {

    public static void main(String[] args) {
        whenParallelStream_thenPerformOperationsInParallel();
    }

    public static void whenParallelStream_thenPerformOperationsInParallel() {
        Employee1[] arrayOfEmps = {
                new Employee1(1, "Jeff Bezos", 100000.0),
                new Employee1(2, "Bill Gates", 200000.0),
                new Employee1(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee1> empList = Arrays.asList(arrayOfEmps);

        // Using parallel stream to increment salaries
        empList.parallelStream().forEach(e -> e.salaryIncrement(10.0));

        // Print updated salaries
        empList.forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));
    }
}
