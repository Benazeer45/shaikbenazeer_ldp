package SOLID_Principles.ISP.ISPCorrected;

public class DriverAssignment implements DriverAssigner {
    @Override
    public void assignDriver(String driverName) {
        System.out.println("Assigning driver " + driverName + " to the ride.");
    }
}

