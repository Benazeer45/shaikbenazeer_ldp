package Java_Assignments.Assignment6;

import java.util.ArrayList;
import java.util.Arrays;

public class OperatorsAndMore {

    // 1. Vampire Number Function
    public static void printFirst100VampireNumbers() {
        ArrayList<Integer> vampireNumbers = new ArrayList<>();
        int number = 10;

        try {
            while (vampireNumbers.size() < 100) {
                if (isVampireNumber(number)) {
                    vampireNumbers.add(number);
                }
                number++;
            }

            for (int vNum : vampireNumbers) {
                System.out.println(vNum);
            }
        } catch (Exception e) {
            System.err.println("Error encountered while finding vampire numbers: " + e.getMessage());
        }
    }

    private static boolean isVampireNumber(int v) {
        String vStr = Integer.toString(v);
        int n = vStr.length();

        if (n % 2 != 0) {
            return false;
        }

        int halfLength = n / 2;

        for (int x = (int) Math.pow(10, halfLength - 1); x < (int) Math.pow(10, halfLength); x++) {
            if (v % x == 0) {
                int y = v / x;
                if (y >= (int) Math.pow(10, halfLength - 1) && y < (int) Math.pow(10, halfLength)) {
                    if (!hasTrailingZeroes(x, y) && hasSameDigits(vStr, Integer.toString(x), Integer.toString(y))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasTrailingZeroes(int x, int y) {
        return (x % 10 == 0) && (y % 10 == 0);
    }

    private static boolean hasSameDigits(String vStr, String xStr, String yStr) {
        char[] vArr = vStr.toCharArray();
        char[] xArr = (xStr + yStr).toCharArray();
        Arrays.sort(vArr);
        Arrays.sort(xArr);
        return Arrays.equals(vArr, xArr);
    }

    // 2. Class with Overloaded Constructors
    static class OverloadedConstructors {
        private int value;

        // First constructor (default)
        public OverloadedConstructors() {
            this(42);
            System.out.println("First constructor called");
        }

        // Second constructor (parameterized)
        public OverloadedConstructors(int value) {
            this.value = value;
            System.out.println("Second constructor called with value: " + value);
        }
    }

    // 3. Class with String Constructor
    static class StringConstructorClass {
        public StringConstructorClass(String message) {
            System.out.println("Constructor called with message: " + message);
        }
    }

    public static void main(String[] args) {
        try {
            // 1. Print first 100 vampire numbers
            System.out.println("First 100 Vampire Numbers:");
            printFirst100VampireNumbers();

            // 2. Demonstrate Overloaded Constructors
            System.out.println("\nDemonstrating Overloaded Constructors:");
            OverloadedConstructors obj1 = new OverloadedConstructors();

            // 3. Array of Object References with No Initialization
            System.out.println("\nArray of Object References (no initialization):");
            StringConstructorClass[] stringArray = new StringConstructorClass[5];

            // 4. Attach Objects to Array of References
            System.out.println("\nArray of Object References with Objects:");
            stringArray[0] = new StringConstructorClass("Hello");
            stringArray[1] = new StringConstructorClass("World");
            stringArray[2] = new StringConstructorClass("This");
            stringArray[3] = new StringConstructorClass("Is");
            stringArray[4] = new StringConstructorClass("Java");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
