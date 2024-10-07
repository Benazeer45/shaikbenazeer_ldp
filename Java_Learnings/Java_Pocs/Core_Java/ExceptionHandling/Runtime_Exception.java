package Core_Java.ExceptionHandling;

public class Runtime_Exception {
    public static void main(String[] args) {
        // Example 1: StringIndexOutOfBoundsException
        String str = "Hello";
        try {
            char ch = str.charAt(10); // Trying to access index 10, which is out of bounds
            System.out.println("Character at index 10: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String Index Out of Bounds Error: " + e.getMessage());
        }

        // Example 2: ArithmeticException (Zero Division)
        int numerator = 10;
        int denominator = 0;
        try {
            int result = numerator / denominator; // This will throw ArithmeticException
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        }

        // Example 3: ArrayIndexOutOfBoundsException
        int[] numbers = {1, 2, 3};
        try {
            int number = numbers[5]; // Trying to access index 5, which is out of bounds
            System.out.println("Number at index 5: " + number);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds Error: " + e.getMessage());
        }
    }
}
