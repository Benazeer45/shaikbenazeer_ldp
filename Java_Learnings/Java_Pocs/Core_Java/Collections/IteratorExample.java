package Core_Java.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Create an iterator for the list
        Iterator<Integer> iterator = numbers.iterator();

        // Using the iterator to traverse the list
        System.out.println("Iterating through the list:");
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            System.out.println("Number: " + number);

            // Remove an element if it matches a condition
            if (number % 2 == 0) {
                iterator.remove(); // Remove even numbers
                System.out.println("Removed: " + number);
            }
        }

        // Display the modified list
        System.out.println("Modified List: " + numbers);
    }
}
