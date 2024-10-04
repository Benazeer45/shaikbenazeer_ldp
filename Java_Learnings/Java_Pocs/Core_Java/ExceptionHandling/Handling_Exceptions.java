package Core_Java.ExceptionHandling;

public class Handling_Exceptions {
    public static void main(String[] args) {
        // Example 1: Handling division by zero
        try {
            int result = divide(10, 0); // This will throw an ArithmeticException
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("This block executes regardless of exception.");
        }

        // Example 2: Handling NumberFormatException
        String invalidNumber = "abc";

        try {
            int number = parseStringToInt(invalidNumber); // This will throw a NumberFormatException
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        } finally {
            System.out.println("Finished processing the number.");
        }
    }

    public static int divide(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator; // May throw ArithmeticException
    }

    public static int parseStringToInt(String str) throws NumberFormatException {
        return Integer.parseInt(str); // May throw NumberFormatException
    }
}
