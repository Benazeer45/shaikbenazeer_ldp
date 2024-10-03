package SOLID_Principles.LSP.LSPCorrected;

public class RideHailingApp {
    public static void main(String[] args) {
        Ride normalRide = new NormalRide(10.0, 5.0);
        Ride luxuryRide = new LuxuryRide(20.0, 5.0, 50.0);

        normalRide.displayRideDetails();
        luxuryRide.displayRideDetails();
    }
}

