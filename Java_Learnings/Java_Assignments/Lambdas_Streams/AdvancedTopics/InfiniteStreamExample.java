package Java_Assignments.Lambdas_Streams.AdvancedTopics;

import java.util.stream.Stream;

public class InfiniteStreamExample {

    public static void main(String[] args) {
        whenGenerateStream_thenGetInfiniteStream();
        whenIterateStream_thenGetInfiniteStream();
    }

    public static void whenGenerateStream_thenGetInfiniteStream() {
        // Generate 5 random numbers
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void whenIterateStream_thenGetInfiniteStream() {
        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

        // Get first 5 even numbers
        evenNumStream.limit(5).forEach(System.out::println);
    }
}

