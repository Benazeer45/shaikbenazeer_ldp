package SOLID_Principles.SRP.SRPCorrected;

public class RideHailingApp {
    public static void main(String[] args) {
        Ride ride = new Ride("Location A", "Location B", 15.0);
        ride.displayRideDetails();

        Payment payment = new Payment();
        payment.processPayment(ride.getFare());

        DriverAssignment driverAssignment = new DriverAssignment();
        driverAssignment.assignDriver("John Doe");
    }
}
