package SOLID_Principles.LSP.LSPCorrected;

public class LuxuryRide extends Ride {
    private double luxuryFee;

    public LuxuryRide(double baseFare, double distance, double luxuryFee) {
        super(baseFare, distance);
        this.luxuryFee = luxuryFee;
    }

    @Override
    public double calculateFare() {
        return super.calculateFare() + luxuryFee;
    }
}
