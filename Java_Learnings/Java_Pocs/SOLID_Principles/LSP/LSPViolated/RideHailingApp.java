package SOLID_Principles.LSP.LSPViolated;

public class RideHailingApp {
    public static void main(String[] args) {
        Ride normalRide = new NormalRide(10.0, 5.0);
        Ride luxuryRide = new LuxuryRide(20.0, 5.0, 200.0);

        normalRide.displayRideDetails();
        luxuryRide.displayRideDetails();
    }
}

