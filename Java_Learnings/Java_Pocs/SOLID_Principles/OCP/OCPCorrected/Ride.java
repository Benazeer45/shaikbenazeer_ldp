package SOLID_Principles.OCP.OCPCorrected;

public class Ride {
    private String startLocation;
    private String destination;
    private double baseFare; // Base fare without taxes
    private static final double TAX_RATE = 0.15; // Example tax rate of 15%

    // Constructor to initialize ride details
    public Ride(String startLocation, String destination, double baseFare) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    // Method to display ride details
    public void displayRideDetails() {
        System.out.println("Ride from " + startLocation + " to " + destination + ". Base Fare: " + baseFare + ", Total Fare (with taxes): " + getTotalFare());
    }

    // Getter for base fare
    public double getBaseFare() {
        return baseFare;
    }

    // Method to calculate tax amount
    public double getTaxAmount() {
        return baseFare * TAX_RATE;
    }

    // Method to calculate total fare
    public double getTotalFare() {
        return baseFare + getTaxAmount(); // Total fare includes base fare and taxes
    }

    // Method to generate invoice using an invoice generator
    public void generateInvoice(InvoiceGenerator invoiceGenerator) {
        invoiceGenerator.generate(this); // Use the invoice generator to create the invoice
    }

    // Method to process payment (dummy implementation for demonstration)
    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.pay(getTotalFare()); // Processing payment on the total fare
    }

    // Getters for start location and destination
    public String getStartLocation() {
        return startLocation;
    }

    public String getDestination() {
        return destination;
    }
}
