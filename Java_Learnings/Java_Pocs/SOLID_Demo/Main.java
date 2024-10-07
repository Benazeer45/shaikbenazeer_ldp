package SOLID_Principles.SOLID_Demo;

public class Main {
    public static void main(String[] args) {
        // You can easily swap out different implementations of Light without changing the Switch class
        Light lightBulb = new LightBulb();
        Light ledLight = (Light) new LEDLight();

        // Example of using Switch with a LightBulb
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.operate(true);  // Turn on LightBulb
        lightSwitch.operate(false); // Turn off LightBulb

        // Example of using Switch with an LEDLight
        Switch ledSwitch = new Switch(ledLight);
        ledSwitch.operate(true);  // Turn on LEDLight
        ledSwitch.operate(false); // Turn off LEDLight
    }
}

