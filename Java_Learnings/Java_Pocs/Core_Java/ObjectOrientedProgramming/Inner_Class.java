package Core_Java.ObjectOrientedProgramming;

// Outer class representing a Machine
class Machine {
    private String name;

    // Constructor for Machine
    public Machine(String name) {
        this.name = name;
    }

    public void displayMachineInfo() {
        System.out.println("Machine Name: " + name);
    }

    // Subclass representing Artificial Intelligence
    class ArtificialIntelligence {
        private String aiType;

        // Constructor for ArtificialIntelligence
        public ArtificialIntelligence(String aiType) {
            this.aiType = aiType;
        }

        // Method to display AI information
        public void displayAIInfo() {
            System.out.println("Artificial Intelligence Type: " + aiType);
        }
    }

    // Subclass representing Tire
    class Tire {
        private String tireType;

        // Constructor for Tire
        public Tire(String tireType) {
            this.tireType = tireType;
        }

        // Method to display tire information
        public void displayTireInfo() {
            System.out.println("Tire Type: " + tireType);
        }
    }
}

// Class containing the main method
public class Inner_Class {
    public static void main(String[] args) {
        // Creating an instance of Machine
        Machine myMachine = new Machine("Excavator");

        // Displaying machine information
        myMachine.displayMachineInfo();

        // Creating an instance of the subclass ArtificialIntelligence
        Machine.ArtificialIntelligence myAI = myMachine.new ArtificialIntelligence("Deep Learning");
        myAI.displayAIInfo();

        // Creating an instance of the subclass Tire
        Machine.Tire myTire = myMachine.new Tire("All-Terrain");
        myTire.displayTireInfo();
    }
}
