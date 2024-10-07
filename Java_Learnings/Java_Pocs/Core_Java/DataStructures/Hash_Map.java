package Core_Java.DataStructures;

import java.util.HashMap;
import java.util.Map;

public class Hash_Map {
    public static void main(String[] args) {
        // Create a HashMap with Integer keys and String values
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs to the map
        map.put(3, "dog");
        map.put(5, "cat");
        map.put(10, "tiger");
        map.put(14, "lion");
        map.put(72, "elephant");
        map.put(5, "tortoise");

        String animal = map.get(5);
        System.out.println(animal);

        // Loop through the entries of the map and print each key-value pair
        for (Map.Entry<Integer, String> myAnimal : map.entrySet()) {
            int key = myAnimal.getKey();
            String value = myAnimal.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
