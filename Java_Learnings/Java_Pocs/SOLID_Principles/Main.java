package SOLID_Principles;

// Interface for handling ride details
interface RideDetails {
    void displayRideDetails();
}

// Interface for handling payment processing
interface PaymentProcessor {
    void processPayment(double amount);
}

// Interface for handling driver assignment
interface DriverAssigner {
    void assignDriver(String driverName);
}

// Ride class (Handles only ride details)
class Ride implements RideDetails {
    private String startLocation;
    private String destination;
    private double fare;

    public Ride(String startLocation, String destination, double fare) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.fare = fare;
    }

    @Override
    public void displayRideDetails() {
        System.out.println("Ride from " + startLocation + " to " + destination + ". Fare: " + fare);
    }

    public double getFare() {
        return fare;
    }
}

// Payment class (Handles payment processing)
class Payment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount);
        // Payment logic here
    }
}

// DriverAssignment class (Handles driver assignment)
class DriverAssignment implements DriverAssigner {
    @Override
    public void assignDriver(String driverName) {
        System.out.println("Assigning driver " + driverName + " to the ride.");
        // Driver assignment logic here
    }
}

// Main application class to demonstrate the corrected code with ISP
public class Main {
    public static void main(String[] args) {
        // Creating ride
        Ride ride = new Ride("Location A", "Location B", 15.0);
        ride.displayRideDetails();

        // Processing payment
        Payment payment = new Payment();
        payment.processPayment(ride.getFare());

        // Assigning driver
        DriverAssignment driverAssignment = new DriverAssignment();
        driverAssignment.assignDriver("John Doe");
    }
}

