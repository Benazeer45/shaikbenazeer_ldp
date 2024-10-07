package Core_Java.DataStructures;

import java.util.Map;
import java.util.TreeMap;

public class Tree_Map {
    public static void main(String[] args) {
        // Create a TreeMap with Integer keys and String values
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Adding key-value pairs to the TreeMap
        treeMap.put(3, "dog");
        treeMap.put(5, "cat");
        treeMap.put(10, "tiger");
        treeMap.put(14, "lion");
        treeMap.put(72, "elephant");
        treeMap.put(1, "tortoise"); // Adding another entry

        // Retrieve and print the value associated with key 5
        String animal = treeMap.get(5);
        System.out.println("Value for key 5: " + animal);

        // Loop through the entries of the TreeMap and print each key-value pair
        System.out.println("TreeMap contents (sorted by keys):");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // Check if a key exists in the map
        if (treeMap.containsKey(10)) {
            System.out.println("Key 10 exists in the TreeMap.");
        } else {
            System.out.println("Key 10 does not exist in the TreeMap.");
        }

        // Check if a value exists in the map
        if (treeMap.containsValue("lion")) {
            System.out.println("Value 'lion' exists in the TreeMap.");
        } else {
            System.out.println("Value 'lion' does not exist in the TreeMap.");
        }

        // Remove an entry
        treeMap.remove(3);
        System.out.println("TreeMap after removing key 3:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Display the size of the TreeMap
        System.out.println("Size of the TreeMap: " + treeMap.size());

        // Clear the TreeMap
        treeMap.clear();
        System.out.println("TreeMap cleared. Is empty? " + treeMap.isEmpty());
    }
}
