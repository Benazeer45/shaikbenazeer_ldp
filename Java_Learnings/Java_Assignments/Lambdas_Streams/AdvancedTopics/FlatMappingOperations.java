package Java_Assignments.Lambdas_Streams.AdvancedTopics;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMappingOperations {
    public static void main(String[] args) {
        // Example for flatMapToInt
        Stream<String> strings = Stream.of("1,2,3", "4,5");
        IntStream intStream = strings.flatMapToInt(s -> Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt));
        System.out.println("flatMapToInt Output:");
        intStream.forEach(System.out::println);  // Outputs: 1 2 3 4 5

        // Example for flatMapToLong
        Stream<String> longStrings = Stream.of("10000000000,20000000000", "30000000000");
        LongStream longStream = longStrings.flatMapToLong(s -> Arrays.stream(s.split(","))
                .mapToLong(Long::parseLong));
        System.out.println("flatMapToLong Output:");
        longStream.forEach(System.out::println);  // Outputs: 10000000000 20000000000 30000000000

        // Example for flatMapToDouble
        Stream<String> doubleStrings = Stream.of("1.1,2.2", "3.3,4.4");
        DoubleStream doubleStream = doubleStrings.flatMapToDouble(s -> Arrays.stream(s.split(","))
                .mapToDouble(Double::parseDouble));
        System.out.println("flatMapToDouble Output:");
        doubleStream.forEach(System.out::println);  // Outputs: 1.1 2.2 3.3 4.4
    }
}
