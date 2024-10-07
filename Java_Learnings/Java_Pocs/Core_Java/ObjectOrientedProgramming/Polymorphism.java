package Core_Java.ObjectOrientedProgramming;

class Vehicle {
    public void start() {
        System.out.println("The vehicle is starting.");
    }

    public void start(int speed) {
        System.out.println("The vehicle is starting at speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("The car is starting.");
    }
}

class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("The bike is starting.");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        myCar.start();
        myBike.start();

        myCar.start(60);
        myBike.start(20);

        Car specificCar = new Car();
        Bike specificBike = new Bike();

        specificCar.start();
        specificBike.start();
    }
}
