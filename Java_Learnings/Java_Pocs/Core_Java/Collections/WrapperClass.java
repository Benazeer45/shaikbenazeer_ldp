package Core_Java.Collections;

import java.util.ArrayList;

public class WrapperClass {

    public static void main(String[] args) {
        // Using Wrapper Classes
        Integer intValue = Integer.valueOf(42); // Integer wrapper
        Double doubleValue = Double.valueOf(3.14); // Double wrapper
        Character charValue = Character.valueOf('A'); // Character wrapper

        // Autoboxing and Unboxing
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(intValue); // Autoboxing
        integerList.add(100); // Autoboxing with primitive
        int num = integerList.get(0); // Unboxing
        System.out.println("Unboxed value: " + num);

        // Using Wrapper Class methods
        System.out.println("Integer Value: " + intValue);
        System.out.println("Double Value: " + doubleValue);
        System.out.println("Character Value: " + charValue);
        System.out.println("Max of 10 and 20: " + Integer.max(10, 20)); // Static method of Integer class

        // Parsing Strings to Primitives
        String intString = "123";
        String doubleString = "45.67";
        int parsedInt = Integer.parseInt(intString); // Parsing to int
        double parsedDouble = Double.parseDouble(doubleString); // Parsing to double

        System.out.println("Parsed Integer: " + parsedInt);
        System.out.println("Parsed Double: " + parsedDouble);

        // Parsing a String to a Wrapper
        String strNumber = "100";
        Integer parsed_Int = Integer.parseInt(strNumber);
        System.out.println("Parsed Integer from String: " + parsed_Int);

        // Converting a wrapper to string
        String intToString = intValue.toString();
        System.out.println("Integer as String: " + intToString);
    }
}
