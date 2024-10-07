package SOLID_Principles.SOLID_Demo;

// SRP: Light interface has only one responsibility - defining light behavior
// DIP: Light interface is an abstraction that can be implemented by various types of lights
public interface Light {
    void turnOn();
    void turnOff();
}
