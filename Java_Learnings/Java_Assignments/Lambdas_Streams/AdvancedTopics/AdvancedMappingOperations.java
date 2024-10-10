package Java_Assignments.Lambdas_Streams.AdvancedTopics;

import java.util.Arrays;
import java.util.stream.Stream;

public class AdvancedMappingOperations {
    public static void main(String[] args) {
        // Example for mapMulti
        System.out.println("mapMulti Output:");
        Stream.of(1, 2, 3).<String>mapMulti((number, consumer) -> {
            consumer.accept(number + "a");
            consumer.accept(number + "b");
        }).forEach(System.out::println);  // Outputs: 1a 1b 2a 2b 3a 3b

        // Example for mapMultiToInt
        System.out.println("mapMultiToInt Output:");
        Stream.of("1,2", "3,4").mapMultiToInt((s, consumer) -> {
            Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).forEach(consumer);
        }).forEach(System.out::println);  // Outputs: 1 2 3 4

        // Example for mapMultiToLong
        System.out.println("mapMultiToLong Output:");
        Stream.of("10000000000,20000000000").mapMultiToLong((s, consumer) -> {
            Arrays.stream(s.split(",")).mapToLong(Long::parseLong).forEach(consumer);
        }).forEach(System.out::println);  // Outputs: 10000000000 20000000000

        // Example for mapMultiToDouble
        System.out.println("mapMultiToDouble Output:");
        Stream.of("1.1,2.2").mapMultiToDouble((s, consumer) -> {
            Arrays.stream(s.split(",")).mapToDouble(Double::parseDouble).forEach(consumer);
        }).forEach(System.out::println);  // Outputs: 1.1 2.2
    }
}

