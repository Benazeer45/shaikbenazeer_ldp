package Core_Java.DataStructures;

import java.util.ArrayList;

public class Array_List {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        // Adding elements
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add(42);
        arrayList.add(3.14);

        // Displaying elements using toString method
        System.out.println("ArrayList: " + arrayList);

        // Getting an element
        System.out.println("Element at index 1: " + arrayList.get(1));

        // Removing an element
        arrayList.remove(2);
        System.out.println("ArrayList after removal: " + arrayList);

        // Displaying size
        System.out.println("Current size: " + arrayList.size());

        // Checking if empty
        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());

        // Using a for loop to retrieve and display all elements
        System.out.println("All elements in the ArrayList:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Element at index " + i + ": " + arrayList.get(i));
        }
    }
}
