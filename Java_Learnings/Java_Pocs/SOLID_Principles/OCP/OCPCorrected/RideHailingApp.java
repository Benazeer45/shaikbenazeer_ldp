package SOLID_Principles.OCP.OCPCorrected;

public class RideHailingApp {
    public static void main(String[] args) {
        Ride ride = new Ride("Location A", "Location B", 15.0);
        ride.displayRideDetails();

        PaymentMethod paymentMethod = new CreditCardPayment();
        ride.processPayment(paymentMethod);

        paymentMethod = new PayPalPayment();
        ride.processPayment(paymentMethod);
    }
}
