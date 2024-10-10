package Java_Assignments.Assignment7;

// CycleFactoryPattern.java
public interface CycleFactory {
    Cycle createCycle();
}

class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle createCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {
    @Override
    public Cycle createCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {
    @Override
    public Cycle createCycle() {
        return new Tricycle();
    }
}
