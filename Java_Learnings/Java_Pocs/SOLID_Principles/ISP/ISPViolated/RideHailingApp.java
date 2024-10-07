package SOLID_Principles.ISP.ISPViolated;

public class RideHailingApp {
    public static void main(String[] args) {
        Ride ride = new Ride("Location A", "Location B", 15.0);
        ride.displayRideDetails();
        ride.processPayment(15.0);
        ride.assignDriver("John Doe");
    }
}

