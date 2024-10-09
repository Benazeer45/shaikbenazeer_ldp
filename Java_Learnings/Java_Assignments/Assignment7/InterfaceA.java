package Java_Assignments.Assignment7;

// InterfaceHierarchy.java
public interface InterfaceA {
    void methodA1();
    void methodA2();
}

class ConcreteClass implements CombinedInterface {
    @Override
    public void methodA1() {
        System.out.println("Method A1 implemented.");
    }

    @Override
    public void methodA2() {
        System.out.println("Method A2 implemented.");
    }

    @Override
    public void methodB1() {
        System.out.println("Method B1 implemented.");
    }

    @Override
    public void methodB2() {
        System.out.println("Method B2 implemented.");
    }

    @Override
    public void methodC1() {
        System.out.println("Method C1 implemented.");
    }

    @Override
    public void methodC2() {
        System.out.println("Method C2 implemented.");
    }

    @Override
    public void combinedMethod() {
        System.out.println("Combined method implemented.");
    }
}

