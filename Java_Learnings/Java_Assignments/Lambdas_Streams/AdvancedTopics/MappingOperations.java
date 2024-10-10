package Java_Assignments.Lambdas_Streams.AdvancedTopics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;

public class MappingOperations {
    public static void main(String[] args) {
        // Example for mapToInt
        List<String> numbersAsString = Arrays.asList("1", "2", "3");
        IntStream intStream = numbersAsString.stream()
                .mapToInt(Integer::parseInt);
        System.out.println("mapToInt Output:");
        intStream.forEach(System.out::println);  // Outputs: 1 2 3

        // Example for mapToLong
        List<String> longNumbersAsString = Arrays.asList("10000000000", "20000000000");
        LongStream longStream = longNumbersAsString.stream()
                .mapToLong(Long::parseLong);
        System.out.println("mapToLong Output:");
        longStream.forEach(System.out::println);  // Outputs: 10000000000 20000000000

        // Example for mapToDouble
        List<String> doubleNumbersAsString = Arrays.asList("1.5", "2.5", "3.5");
        DoubleStream doubleStream = doubleNumbersAsString.stream()
                .mapToDouble(Double::parseDouble);
        System.out.println("mapToDouble Output:");
        doubleStream.forEach(System.out::println);  // Outputs: 1.5 2.5 3.5
    }
}

