package SOLID_Principles.OCP.OCPViolated;
// Ride.java (Violation of OCP)
public class Ride {
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

    // Violation of OCP: payment logic is hardcoded for each payment type
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing Credit Card payment of " + amount);
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Processing PayPal payment of " + amount);
        } else {
            System.out.println("Invalid payment type");
        }
    }
}
