package Core_Java.Packages.First_Package;

import Core_Java.Packages.First_Package.MathUtils; // Importing the MathUtils class from the utils package

public class Main {
    public static void main(String[] args) {
        int sum = MathUtils.add(5, 10);
        int product = MathUtils.multiply(4, 6);

        System.out.println("Sum: " + sum); // Outputs: Sum: 15
        System.out.println("Product: " + product); // Outputs: Product: 24
    }
}
