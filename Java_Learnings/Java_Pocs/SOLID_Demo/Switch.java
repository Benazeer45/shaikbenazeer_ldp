package SOLID_Principles.SOLID_Demo;

// SRP: Switch class only handles turning lights on/off, and does not need to know the specific type of light
// DIP: Switch depends on the abstraction (Light) rather than any specific light implementation
public class Switch {
    private Light light;

    // Constructor injection ensures flexibility and extensibility (DIP)
    public Switch(Light light) {
        this.light = light;
    }

    // Method to operate the switch, following LSP (LightBulb, LEDLight can be used interchangeably)
    public void operate(boolean turnOn) {
        if (turnOn) {
            light.turnOn();
        } else {
            light.turnOff();
        }
    }
}
