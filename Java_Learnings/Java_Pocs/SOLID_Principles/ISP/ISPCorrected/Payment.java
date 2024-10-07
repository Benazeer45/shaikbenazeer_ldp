package SOLID_Principles.ISP.ISPCorrected;

public class Payment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount);
    }
}
