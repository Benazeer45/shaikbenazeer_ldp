package SOLID_Principles.OCP.OCPCorrected;

public class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }
}

