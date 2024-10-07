package SOLID_Principles.ISP.ISPViolated;

public class Ride implements RideOperations {
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

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount);
    }

    @Override
    public void assignDriver(String driverName) {
        System.out.println("Assigning driver " + driverName + " to the ride.");
    }
}


