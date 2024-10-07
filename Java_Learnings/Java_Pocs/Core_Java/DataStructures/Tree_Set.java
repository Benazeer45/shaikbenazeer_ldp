package Core_Java.DataStructures;

import java.util.TreeSet;

public class Tree_Set{
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<String> treeSet = new TreeSet<>();

        // Adding elements
        treeSet.add("Grapes");
        treeSet.add("Apple");
        treeSet.add("Orange");
        treeSet.add("Banana");
        treeSet.add("Cherry");
        treeSet.add("Apple"); // Duplicate entry (will be ignored)

        // Displaying the TreeSet (sorted order)
        System.out.println("TreeSet: " + treeSet);

        // Checking for existence
        if (treeSet.contains("Banana")) {
            System.out.println("TreeSet contains Banana.");
        }

        // Removing an element
        treeSet.remove("Cherry");
        System.out.println("After removing Cherry: " + treeSet);

        // Iterating through the TreeSet
        System.out.println("Iterating through TreeSet:");
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }

        // Size of the TreeSet
        System.out.println("Size of TreeSet: " + treeSet.size());

        // Clearing the TreeSet
        treeSet.clear();
        System.out.println("TreeSet cleared. Is empty? " + treeSet.isEmpty());
    }
}
