package Core_Java.FunctionalProgramming;

// Define the first functional interface with a method that takes an int and returns an int
interface FunctionalInterface {
    int start(int value1, int value2);
}

// Define another functional interface with a method that takes a String and returns an int
interface AnotherFunctionalInterface {
    int start(String value);
}

// Car class with methods that accept the functional interfaces
class Car1 {
    public void drive(FunctionalInterface obj) {
        System.out.println("Driving the car...");
        int number = obj.start(18, 2); // Example values
        System.out.println("Returning the number: " + number);
    }

    public void drive(AnotherFunctionalInterface obj) {
        System.out.println("Driving the car...");
        int number = obj.start("Hi there!");
        System.out.println("Returning the number: " + number);
    }
}

// Application class with the main method
public class Lambda_Expressions {
    public static void main(String[] args) {
        Car1 car = new Car1();

        // Using an anonymous class with the first functional interface
        car.drive(new FunctionalInterface() {
            @Override
            public int start(int value1, int value2) {
                System.out.println("Start driving using an anonymous class...");
                return value1 + value2; // Example operation
            }
        });

        System.out.println("");

        // Using a lambda expression with the first functional interface
        car.drive((value1, value2) -> {
            System.out.println("Start driving using a lambda expression...");
            return value1 * value2; // Example operation
        });

        System.out.println("");

        // Using an anonymous class with the second functional interface
        car.drive(new AnotherFunctionalInterface() {
            @Override
            public int start(String value) {
                System.out.println("Start driving using another anonymous class...");
                return value.length(); // Example operation
            }
        });

        System.out.println("");

        // Using a lambda expression with the second functional interface
        car.drive(value -> {
            System.out.println("Start driving using another lambda expression...");
            return value.length(); // Example operation
        });
    }
}
