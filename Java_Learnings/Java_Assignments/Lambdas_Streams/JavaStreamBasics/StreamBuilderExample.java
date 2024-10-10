package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.stream.Stream;

public class StreamBuilderExample {
    public static void main(String[] args) {
        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
        empStreamBuilder.accept(new Employee(1, "Jeff Bezos", 100000.0));
        empStreamBuilder.accept(new Employee(2, "Bill Gates", 200000.0));
        empStreamBuilder.accept(new Employee(3, "Mark Zuckerberg", 300000.0));

        Stream<Employee> empStream = empStreamBuilder.build();
        empStream.forEach(System.out::println);
    }
}

