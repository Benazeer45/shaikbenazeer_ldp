package SOLID_Principles.OCP.OCPCorrected;

// Implementation of the InvoiceGenerator interface
public class ConsoleInvoiceGenerator implements InvoiceGenerator {
    @Override
    public void generate(Ride ride) {
        System.out.println("Ride Invoice");
        System.out.println("From: " + ride.getStartLocation());
        System.out.println("To: " + ride.getDestination());
        System.out.println("Base Fare: " + ride.getBaseFare());
        System.out.println("Tax: " + ride.getTaxAmount());
        System.out.println("Total Fare: " + ride.getTotalFare());
    }
}
