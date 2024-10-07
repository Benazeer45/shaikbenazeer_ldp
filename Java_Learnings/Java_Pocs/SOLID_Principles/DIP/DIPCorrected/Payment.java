package SOLID_Principles.DIP.DIPCorrected;

public class Payment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount);
    }
}

