package Java_Assignments.Lambdas_Streams.JavaStreamsImprovement;


import java.util.stream.Stream;

public class OfNullableExample {
    public static void runExample() {
        Integer number = null;
        Stream<Integer> result = Stream.ofNullable(number);
        result.map(x -> x * x).forEach(System.out::println);
    }
}

