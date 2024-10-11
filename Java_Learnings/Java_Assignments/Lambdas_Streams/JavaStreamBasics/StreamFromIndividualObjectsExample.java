package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.stream.Stream;

public class StreamFromIndividualObjectsExample {
    public static void main(String[] args) {
        // Create a stream from individual Employee objects
        Stream<Employee> employeeStream = Stream.of(
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        );

        employeeStream.forEach(System.out::println);
    }
}
