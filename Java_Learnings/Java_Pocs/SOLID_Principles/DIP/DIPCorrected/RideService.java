package SOLID_Principles.DIP.DIPCorrected;

public class RideService {
    private PaymentProcessor paymentProcessor;

    public RideService(PaymentProcessor paymentProcessor) { // Dependency Injection
        this.paymentProcessor = paymentProcessor; // Dependency on abstraction
    }

    public void createRide(String startLocation, String destination, double fare) {
        System.out.println("Creating ride from " + startLocation + " to " + destination + ". Fare: " + fare);
        paymentProcessor.processPayment(fare);
    }
}

