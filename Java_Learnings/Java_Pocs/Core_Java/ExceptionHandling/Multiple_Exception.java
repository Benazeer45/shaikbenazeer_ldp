package Core_Java.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Multiple_Exception {
    public static void main(String[] args) {
        // Example 1: Handling IOException and FileNotFoundException
        try {
            readFile("non_existent_file.txt"); // This will throw FileNotFoundException
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }

        // Example 2: Handling ParseException
        String dateStr = "2023-31-12"; // Invalid date format
        try {
            parseDate(dateStr);
        } catch (ParseException e) {
            System.out.println("Parse Error: " + e.getMessage());
        }

        // Example 3: Handling NumberFormatException
        String invalidNumber = "abc";
        try {
            int number = convertStringToInt(invalidNumber); // This will throw NumberFormatException
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Number Format Error: " + e.getMessage());
        }

        // Example 4: Handling ArithmeticException
        try {
            int result = divide(10, 0); // This will throw ArithmeticException
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        }
    }

    // Method to read a file and potentially throw an IOException
    public static void readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Method to parse a date string and potentially throw a ParseException
    public static void parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.parse(dateStr); // May throw ParseException
    }

    // Method to convert a string to an integer and potentially throw a NumberFormatException
    public static int convertStringToInt(String str) throws NumberFormatException {
        return Integer.parseInt(str); // May throw NumberFormatException
    }

    // Method to perform division and potentially throw an ArithmeticException
    public static int divide(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator; // May throw ArithmeticException
    }
}
