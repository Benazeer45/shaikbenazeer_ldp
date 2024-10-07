package Core_Java.AdvancedConcepts;

public class StringBuilder {

    public static void main(String[] args) {
        // Creating a normal String
        String normalString = "Hello";
        normalString = normalString + ", World!"; // Concatenating a String
        System.out.println("Normal String: " + normalString);

        // Using the built-in StringBuilder for the first StringBuilder
        java.lang.StringBuilder stringBuilder1 = new java.lang.StringBuilder();
        stringBuilder1.append("Hello"); // Appending to the first StringBuilder
        stringBuilder1.append(", this is the first StringBuilder.");
        System.out.println("StringBuilder 1: " + stringBuilder1.toString()); // Convert to String for display

        // Using the built-in StringBuilder for the second StringBuilder
        java.lang.StringBuilder stringBuilder2 = new java.lang.StringBuilder();
        stringBuilder2.append("Hello"); // Appending to the second StringBuilder
        stringBuilder2.append(", this is the second StringBuilder.");
        System.out.println("StringBuilder 2: " + stringBuilder2.toString()); // Convert to String for display
    }
}
