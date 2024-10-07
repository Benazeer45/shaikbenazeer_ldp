package Core_Java.ObjectOrientedProgramming;

// Define an interface
interface Vehicle_Interface {
    void start();
    void stop();
    int getSpeed();
}

// Implement the interface in a class
class Car_Interface implements Vehicle_Interface {
    private int speed;

    // Constructor to initialize speed
    public Car_Interface(int speed) {
        this.speed = speed;
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}

// Implement the interface in another class
class Bicycle_Interface implements Vehicle_Interface {
    private int speed;

    // Constructor to initialize speed
    public Bicycle_Interface(int speed) {
        this.speed = speed;
    }

    @Override
    public void start() {
        System.out.println("Bicycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle is stopping...");
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}

// Main class to demonstrate interface implementation
public class Interfaces {
    public static void main(String[] args) {
        // Create objects of Car and Bicycle
        Vehicle_Interface myCar = new Car_Interface(120);
        Vehicle_Interface myBicycle = new Bicycle_Interface(20);

        // Start the vehicles
        myCar.start();
        myBicycle.start();

        // Get and display their speeds
        System.out.println("Car speed: " + myCar.getSpeed() + " km/h");
        System.out.println("Bicycle speed: " + myBicycle.getSpeed() + " km/h");

        // Stop the vehicles
        myCar.stop();
        myBicycle.stop();
    }
}
