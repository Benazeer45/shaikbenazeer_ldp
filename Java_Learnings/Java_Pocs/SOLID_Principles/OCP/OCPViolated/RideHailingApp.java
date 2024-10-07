package SOLID_Principles.OCP.OCPViolated;
// RideHailingApp.java (Violation of OCP)
public class RideHailingApp {
    public static void main(String[] args) {
        Ride ride = new Ride("Location A", "Location B", 15.0);
        ride.displayRideDetails();

        // Processing payment via Credit Card
        ride.processPayment("CreditCard", 15.0);
    }
}


