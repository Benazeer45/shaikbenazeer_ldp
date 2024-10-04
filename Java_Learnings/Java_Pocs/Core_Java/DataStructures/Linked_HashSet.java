package Core_Java.DataStructures;

import java.util.LinkedHashSet;

public class Linked_HashSet {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Adding elements
        linkedHashSet.add("Dog");
        linkedHashSet.add("Cat");
        linkedHashSet.add("Elephant");
        linkedHashSet.add("Tiger");
        linkedHashSet.add("Cat"); // Duplicate entry (will be ignored)

        // Displaying the LinkedHashSet
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Checking for existence
        if (linkedHashSet.contains("Dog")) {
            System.out.println("LinkedHashSet contains Dog.");
        }

        // Removing an element
        linkedHashSet.remove("Tiger");
        System.out.println("After removing Tiger: " + linkedHashSet);

        // Iterating through the LinkedHashSet
        System.out.println("Iterating through LinkedHashSet:");
        for (String animal : linkedHashSet) {
            System.out.println(animal);
        }

        // Size of the LinkedHashSet
        System.out.println("Size of LinkedHashSet: " + linkedHashSet.size());

        // Clearing the LinkedHashSet
        linkedHashSet.clear();
        System.out.println("LinkedHashSet cleared. Is empty? " + linkedHashSet.isEmpty());
    }
}
