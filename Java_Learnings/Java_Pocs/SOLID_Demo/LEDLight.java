package SOLID_Principles.SOLID_Demo;


// OCP: We can extend the system with new types of lights without modifying existing code
public class LEDLight implements Light {
    @Override
    public void turnOn() {
        System.out.println("LED Light is on");
    }

    @Override
    public void turnOff() {
        System.out.println("LED Light is off");
    }
}
