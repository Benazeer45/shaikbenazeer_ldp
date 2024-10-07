package Core_Java.DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting_Lists {

    public static void main(String[] args) {
        Sorting_Lists sortingLists = new Sorting_Lists();
        sortingLists.sortStringList();
        sortingLists.sortIntegerList();
    }

    public void sortStringList() {
        // Sorting a list of Strings
        List<String> stringList = new ArrayList<>();
        stringList.add("Banana");
        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Grapes");

        System.out.println("Original String List: " + stringList);

        // Sorting using Collections.sort() method
        Collections.sort(stringList);
        System.out.println("Sorted String List: " + stringList);

        // Using custom comparator for strings
        StringComparator stringComparator = new StringComparator();
        Collections.sort(stringList, stringComparator);
        System.out.println("Sorted String List using custom comparator: " + stringList);
    }

    public void sortIntegerList() {
        // Sorting a list of Integers
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(2);
        integerList.add(8);
        integerList.add(1);

        System.out.println("Original Integer List: " + integerList);

        // Sorting using Collections.sort() method
        Collections.sort(integerList);
        System.out.println("Sorted Integer List: " + integerList);

        // Using custom comparator for integers
        IntegerComparator integerComparator = new IntegerComparator();
        Collections.sort(integerList, integerComparator);
        System.out.println("Sorted Integer List using custom comparator: " + integerList);
    }

    // Custom Comparator for Strings
    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            // Compare strings based on their lengths first, then lexicographically
            if (str1.length() != str2.length()) {
                return Integer.compare(str1.length(), str2.length());
            } else {
                return str1.compareTo(str2);
            }
        }
    }

    // Custom Comparator for Integers
    class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer int1, Integer int2) {
            // Compare integers in reverse order
            return int2.compareTo(int1);
        }
    }
}
