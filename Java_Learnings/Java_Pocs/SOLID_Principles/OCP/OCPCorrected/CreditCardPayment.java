package SOLID_Principles.OCP.OCPCorrected;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment of " + amount);
    }
}

