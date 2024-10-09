package Java_Assignments.Assignment8;

import java.util.Scanner;

// Custom Exceptions
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super(message);
    }
}

// Main Class with Exception Handling
public class ErrorHandling {

    public void checkData(String name, Integer age) throws InvalidAgeException, InvalidNameException, DataNotFoundException {
        if (age == null) {
            throw new NullPointerException("Age cannot be null.");
        }
        if (age < 0 || age > 80) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("Invalid name: " + name);
        }
        if ("unknown".equalsIgnoreCase(name)) {
            throw new DataNotFoundException("Data not found for name: " + name);
        }

        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        ErrorHandling demo = new ErrorHandling();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter name (or type 'exit' to quit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            System.out.print("Enter age: ");
            Integer age;
            try {
                age = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for age. Please enter a valid number.");
                continue;
            }

            try {
                demo.checkData(name, age);
            } catch (InvalidAgeException | InvalidNameException | DataNotFoundException e) {
                System.out.println("Caught Exception: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Caught Exception: " + e.getMessage());
            } finally {
                System.out.println("Finally block executed.\n");
            }
        }

    }
}
