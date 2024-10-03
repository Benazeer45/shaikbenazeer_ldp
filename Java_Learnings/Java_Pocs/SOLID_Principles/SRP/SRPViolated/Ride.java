package SOLID_Principles.SRP.SRPViolated;

class Ride {

    private String startLocation;
    private String destination;
    private double fare;

    public Ride(String startLocation, String destination, double fare) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.fare = fare;

    }

    public void displayRideDetails() {
        System.out.println("Ride from " + startLocation + " to " + destination + ". Fare: " + fare);
    }

    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount);
    }

    public void assignDriver(String driverName) {
        System.out.println("Assigning driver " + driverName + " to the ride.");
    }
}

