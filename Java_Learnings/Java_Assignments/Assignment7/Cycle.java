package Java_Assignments.Assignment7;

// CycleHierarchy
public class Cycle {
    public Cycle() {
        System.out.println("Cycle created.");
    }
}

class Unicycle extends Cycle {
    public void balance() {
        System.out.println("Unicycle balance method.");
    }
}

class Bicycle extends Cycle {
    public void balance() {
        System.out.println("Bicycle balance method.");
    }
}

class Tricycle extends Cycle {
    // No balance method
}

