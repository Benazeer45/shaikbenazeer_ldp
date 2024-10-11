package Java_Assignments.Lambdas_Streams.JavaStreamsImprovement;


import java.util.stream.Stream;

public class DropWhileExample {
    public static void runExample() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
                .dropWhile(x -> x <= 5)
                .forEach(System.out::println);
    }
}

