package Java_Assignments.Assignment7;

// RodentHierarchy.java
public abstract class Rodent {
    public Rodent() {
        System.out.println("A new rodent is created.");
    }

    public abstract void eat();
    public abstract void sleep();
}

class Mouse extends Rodent {
    public Mouse() {
        System.out.println("Mouse created.");
    }

    @Override
    public void eat() {
        System.out.println("Mouse is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Mouse is sleeping.");
    }
}

class Gerbil extends Rodent {
    public Gerbil() {
        System.out.println("Gerbil created.");
    }

    @Override
    public void eat() {
        System.out.println("Gerbil is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Gerbil is sleeping.");
    }
}

class Hamster extends Rodent {
    public Hamster() {
        System.out.println("Hamster created.");
    }

    @Override
    public void eat() {
        System.out.println("Hamster is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Hamster is sleeping.");
    }
}

