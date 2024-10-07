package SOLID_Principles.SOLID_Demo;

// LSP & ISP: LightBulb can be substituted for any class implementing Light, no extra unused methods
public class LightBulb implements Light {
    @Override
    public void turnOn() {
        System.out.println("LightBulb is on");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb is off");
    }
}
