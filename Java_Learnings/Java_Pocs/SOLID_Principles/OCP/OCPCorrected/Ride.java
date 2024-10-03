package SOLID_Principles.OCP.OCPCorrected;

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

    public double getFare() {
        return fare;
    }

    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.pay(getFare());
    }
}
