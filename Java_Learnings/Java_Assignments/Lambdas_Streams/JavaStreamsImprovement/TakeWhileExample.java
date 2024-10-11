package Java_Assignments.Lambdas_Streams.JavaStreamsImprovement;


import java.util.stream.Stream;

public class TakeWhileExample {
    public static void runExample() {
        Stream.iterate(1, i -> i + 1)
                .takeWhile(n -> n <= 10)
                .map(x -> x * x)
                .forEach(System.out::println);
    }
}

