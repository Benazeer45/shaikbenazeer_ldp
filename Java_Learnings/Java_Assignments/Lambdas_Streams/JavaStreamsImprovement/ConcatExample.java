package Java_Assignments.Lambdas_Streams.JavaStreamsImprovement;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcatExample {
     public static void runExample() {
            Stream<String> firstStream = Stream.of("A", "B", "C");
            Stream<String> secondStream = Stream.of("D", "E", "F");

            Stream<String> concatenatedStream = Stream.concat(firstStream, secondStream);
            concatenatedStream.forEach(System.out::println);

            // Example with IntStream
            IntStream firstIntStream = IntStream.of(1, 2, 3);
            IntStream secondIntStream = IntStream.of(4, 5, 6);

            IntStream.concat(firstIntStream, secondIntStream).forEach(System.out::println);
        }
    }

