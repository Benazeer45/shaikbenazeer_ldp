package Core_Java.DataStructures;

import java.util.LinkedList;

public class Linked_List {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Adding elements
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add(42);
        linkedList.add(3.14);

        // Displaying elements using toString method
        System.out.println("LinkedList: " + linkedList);

        // Getting an element
        System.out.println("Element at index 1: " + linkedList.get(1));

        // Removing an element
        linkedList.remove(2);
        System.out.println("LinkedList after removal: " + linkedList);

        // Displaying size
        System.out.println("Current size: " + linkedList.size());

        // Checking if empty
        System.out.println("Is LinkedList empty? " + linkedList.isEmpty());

        // Using a for loop to retrieve and display all elements
        System.out.println("All elements in the LinkedList:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("Element at index " + i + ": " + linkedList.get(i));
        }
    }
}

