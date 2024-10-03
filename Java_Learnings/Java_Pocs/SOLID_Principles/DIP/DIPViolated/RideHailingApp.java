package SOLID_Principles.DIP.DIPViolated;

public class RideHailingApp {
    public static void main(String[] args) {
        RideService rideService = new RideService();
        rideService.createRide("Location A", "Location B", 15.0);
    }
}

