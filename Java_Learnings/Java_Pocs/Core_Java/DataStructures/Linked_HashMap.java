package Core_Java.DataStructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class Linked_HashMap {
    public static void main(String[] args) {
        // Create a LinkedHashMap with Integer keys and String values
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // Adding key-value pairs to the LinkedHashMap
        linkedHashMap.put(3, "dog");
        linkedHashMap.put(5, "cat");
        linkedHashMap.put(10, "tiger");
        linkedHashMap.put(14, "lion");
        linkedHashMap.put(72, "elephant");
        linkedHashMap.put(5, "tortoise"); // This will replace the previous value for key 5

        // Retrieve and print the value associated with key 5
        String animal = linkedHashMap.get(5);
        System.out.println("Value for key 5: " + animal);

        // Loop through the entries of the LinkedHashMap and print each key-value pair
        System.out.println("LinkedHashMap contents:");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // Check if a key exists in the map
        if (linkedHashMap.containsKey(10)) {
            System.out.println("Key 10 exists in the LinkedHashMap.");
        } else {
            System.out.println("Key 10 does not exist in the LinkedHashMap.");
        }

        // Check if a value exists in the map
        if (linkedHashMap.containsValue("lion")) {
            System.out.println("Value 'lion' exists in the LinkedHashMap.");
        } else {
            System.out.println("Value 'lion' does not exist in the LinkedHashMap.");
        }

        // Remove an entry
        linkedHashMap.remove(3);
        System.out.println("LinkedHashMap after removing key 3:");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Display the size of the LinkedHashMap
        System.out.println("Size of the LinkedHashMap: " + linkedHashMap.size());

        // Clear the LinkedHashMap
        linkedHashMap.clear();
        System.out.println("LinkedHashMap cleared. Is empty? " + linkedHashMap.isEmpty());
    }
}
