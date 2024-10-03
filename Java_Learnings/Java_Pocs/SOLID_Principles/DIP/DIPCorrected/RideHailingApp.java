package SOLID_Principles.DIP.DIPCorrected;

public class RideHailingApp {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new Payment(); // High-level module depends on abstraction
        RideService rideService = new RideService(paymentProcessor); // Injecting dependency
        rideService.createRide("Location A", "Location B", 15.0);
    }
}

