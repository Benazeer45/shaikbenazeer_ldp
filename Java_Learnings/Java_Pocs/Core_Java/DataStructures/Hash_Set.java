package Core_Java.DataStructures;

import java.util.HashSet;

public class Hash_Set {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> hashSet = new HashSet<>();

        // Adding elements
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Mango");
        hashSet.add("Banana"); // Duplicate entry (will be ignored)

        // Displaying the HashSet
        System.out.println("HashSet: " + hashSet);

        // Checking for existence
        if (hashSet.contains("Apple")) {
            System.out.println("HashSet contains Apple.");
        }

        // Removing an element
        hashSet.remove("Mango");
        System.out.println("After removing Mango: " + hashSet);

        // Iterating through the HashSet
        System.out.println("Iterating through HashSet:");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }

        // Size of the HashSet
        System.out.println("Size of HashSet: " + hashSet.size());

        // Clearing the HashSet
        hashSet.clear();
        System.out.println("HashSet cleared. Is empty? " + hashSet.isEmpty());
    }
}

