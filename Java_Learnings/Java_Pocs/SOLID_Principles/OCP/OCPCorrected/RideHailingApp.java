package SOLID_Principles.OCP.OCPCorrected;

public class RideHailingApp {

        public static void main(String[] args) {
            Ride ride = new Ride("Location A", "Location B", 100.0);
            ride.displayRideDetails(); // Display ride details

            // Create an invoice generator and generate an invoice
            InvoiceGenerator invoiceGenerator = new ConsoleInvoiceGenerator();
            ride.generateInvoice(invoiceGenerator); // Generate invoice
        }
    }

