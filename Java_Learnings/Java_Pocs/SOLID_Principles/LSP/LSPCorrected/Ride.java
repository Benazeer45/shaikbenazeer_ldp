package SOLID_Principles.LSP.LSPCorrected;

public class Ride {
    protected double baseFare;
    protected double distance;

    public Ride(double baseFare, double distance) {
        this.baseFare = baseFare;
        this.distance = distance;
    }

    public double calculateFare() {
        return baseFare * distance;
    }

    public void displayRideDetails() {
        System.out.println("Base fare: " + baseFare + ", Distance: " + distance);
        System.out.println("Calculated fare: " + calculateFare());
    }
}

