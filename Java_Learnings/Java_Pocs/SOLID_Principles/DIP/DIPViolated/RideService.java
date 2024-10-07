package SOLID_Principles.DIP.DIPViolated;

public class RideService {
    private Payment payment;

    public RideService() {
        payment = new Payment();
    }

    public void createRide(String startLocation, String destination, double fare) {
        System.out.println("Creating ride from " + startLocation + " to " + destination + ". Fare: " + fare);
        payment.processPayment(fare);
    }
}

