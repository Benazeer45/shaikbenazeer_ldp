package Java_Assignments.Lambdas_Streams.AdvancedTopics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg")
        );

        // Flattening nested names
        List<String> namesFlat = namesNested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(namesFlat);
    }
}

