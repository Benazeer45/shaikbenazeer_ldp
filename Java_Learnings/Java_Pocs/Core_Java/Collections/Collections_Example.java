package Core_Java.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.Stack;

public class Collections_Example {
    public static void main(String[] args) {
        // ArrayList
        System.out.println("ArrayList:");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add(1, "Orange"); // Inserting at index 1
        System.out.println("ArrayList: " + fruits);
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
        System.out.println("Fruit at index 0: " + fruits.get(0));
        System.out.println("Size of ArrayList: " + fruits.size());
        System.out.println();

        // LinkedList
        System.out.println("LinkedList:");
        LinkedList<String> cities = new LinkedList<>();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.addFirst("Chicago"); // Inserting at the beginning
        System.out.println("LinkedList: " + cities);
        cities.removeLast();
        System.out.println("After removing last city: " + cities);
        System.out.println("First city: " + cities.getFirst());
        System.out.println();

        // Vector
        System.out.println("Vector:");
        Vector<String> languages = new Vector<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        System.out.println("Vector: " + languages);
        languages.remove(1); // Removing element at index 1
        System.out.println("After removal: " + languages);
        System.out.println("Size of Vector: " + languages.size());
        System.out.println();

        // HashSet
        System.out.println("HashSet:");
        HashSet<String> animals = new HashSet<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Dog"); // Duplicate will be ignored
        System.out.println("HashSet: " + animals);
        System.out.println("Contains Cat? " + animals.contains("Cat"));
        animals.remove("Cat");
        System.out.println("After removal: " + animals);
        System.out.println();

        // LinkedHashSet
        System.out.println("LinkedHashSet:");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        linkedHashSet.add("C");
        linkedHashSet.add("A"); // Duplicate will be ignored
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println();

        // TreeSet
        System.out.println("TreeSet:");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(15);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("First element: " + treeSet.first());
        System.out.println("Last element: " + treeSet.last());
        System.out.println();

        // HashMap
        System.out.println("HashMap:");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println("HashMap: " + map);
        System.out.println("Value for key 2: " + map.get(2));
        map.remove(2);
        System.out.println("After removal: " + map);
        System.out.println("Keys: " + map.keySet());
        System.out.println();

        // LinkedHashMap
        System.out.println("LinkedHashMap:");
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println();

        // TreeMap
        System.out.println("TreeMap:");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println("TreeMap: " + treeMap);
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println();

        // PriorityQueue
        System.out.println("PriorityQueue:");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(20);
        priorityQueue.add(10);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Head of the queue: " + priorityQueue.peek());
        System.out.println("Removed head: " + priorityQueue.poll());
        System.out.println();

        // ArrayDeque
        System.out.println("ArrayDeque:");
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("First");
        deque.add("Second");
        deque.addFirst("Zero"); // Adding at the front
        System.out.println("ArrayDeque: " + deque);
        System.out.println("Removed first: " + deque.removeFirst());
        System.out.println("ArrayDeque after removal: " + deque);
        System.out.println();

        // Stack
        System.out.println("Stack:");
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Stack: " + stack);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }
}
