package Java_Assignments.Assignment7;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Problem 1: Rodent Hierarchy
        System.out.println("Problem 1: Rodent Hierarchy");
        Rodent[] rodents = { new Mouse(), new Gerbil(), new Hamster() };
        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
        }

        // Problem 2: Cycle Hierarchy
        System.out.println("\nProblem 2: Cycle Hierarchy");
        Cycle[] cycles = { new Unicycle(), new Bicycle(), new Tricycle() };
        for (Cycle cycle : cycles) {
            try {
                if (cycle instanceof Unicycle) {
                    ((Unicycle) cycle).balance();
                } else if (cycle instanceof Bicycle) {
                    ((Bicycle) cycle).balance();
                } else {
                    System.out.println("No balance method for Tricycle.");
                }
            } catch (ClassCastException e) {
                System.out.println("Invalid downcast attempt.");
            }
        }

        // Problem 3: Interfaces and Inheritance
        System.out.println("\nProblem 3: Interfaces and Inheritance");
        ConcreteClass obj = new ConcreteClass();
        obj.methodA1();
        obj.methodB1();
        obj.methodC1();
        obj.combinedMethod();

        // Problem 4: Cycle Factories
        System.out.println("\nProblem 4: Cycle Factories");
        CycleFactory unicycleFactory = new UnicycleFactory();
        CycleFactory bicycleFactory = new BicycleFactory();
        CycleFactory tricycleFactory = new TricycleFactory();

        unicycleFactory.createCycle();
        bicycleFactory.createCycle();
        tricycleFactory.createCycle();

        // Problem 5: Inner Classes
        System.out.println("\nProblem 5: Inner Classes");
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass("RodentInner");

        SecondOuterClass secondOuter = new SecondOuterClass();
        SecondOuterClass.SecondInnerClass secondInner = secondOuter.new SecondInnerClass(outer, "RodentInner");
    }
}

