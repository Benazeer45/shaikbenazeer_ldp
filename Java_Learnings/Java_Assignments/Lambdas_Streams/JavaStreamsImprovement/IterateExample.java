package Java_Assignments.Lambdas_Streams.JavaStreamsImprovement;


import java.util.stream.Stream;

public class IterateExample {
    public static void runExample() {
        Stream.iterate(1, i -> i < 256, i -> i * 2)
                .forEach(System.out::println);
    }
}

