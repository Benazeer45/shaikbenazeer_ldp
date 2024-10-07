package Core_Java.ObjectOrientedProgramming;

// Laptop class definition
class Laptop {
    private int id;
    private String brand;

    // Constructor to initialize the Laptop object
    public Laptop(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    // Overriding the toString() method
    @Override
    public String toString() {
        return "Laptop (id=" + id + ", brand=" + brand + ")";
    }

    // Overriding the hashCode() method
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + id; // Include id in the hash code
        return result;
    }

    // Overriding the equals() method
    @Override
    public boolean equals(Object obj) {
        // Check if the object is the same instance
        if (this == obj) return true;
        // Check if the object is null
        if (obj == null) return false;
        // Check if the classes are the same
        if (getClass() != obj.getClass()) return false;

        Laptop other = (Laptop) obj; // Cast the object to Laptop
        // Compare the id and brand of both Laptop objects
        return id == other.id && (brand != null ? brand.equals(other.brand) : other.brand == null);
    }
}

// Application class to test the Laptop class
public class Equals_Method {
    public static void main(String[] args) {
        // Creating Laptop objects
        Laptop laptop1 = new Laptop(250, "HP");
        Laptop laptop2 = new Laptop(90, "DELL");

        // Printing laptop details using toString()
        System.out.println(laptop1);
        System.out.println(laptop2);

        // Checking equality of two Laptop objects
        System.out.println("Are laptop1 and laptop2 equal? " + laptop1.equals(laptop2));

        // Example of comparing numbers
        int firstNumber = 8;
        int secondNumber = 8;

        System.out.println("First number is equal to second number: " + (firstNumber == secondNumber));

        // Example substring usage
        String str = "Yes";
        String substring = str.substring(0, 3);
        System.out.println("Substring of 'Yes': " + substring);
    }
}
