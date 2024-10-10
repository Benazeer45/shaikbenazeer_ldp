package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.stream.Stream;

public class StreamCreationExample {
    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    public static void main(String[] args) {
        // Create a stream from an array
        Stream<Employee> employeeStream = Stream.of(arrayOfEmps);
        System.out.println("Employees from array:");
        employeeStream.forEach(System.out::println);
    }
}
