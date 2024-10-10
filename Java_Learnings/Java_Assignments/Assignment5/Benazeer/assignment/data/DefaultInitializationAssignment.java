package Java_Assignments.Assignment5.Benazeer.assignment.data;

public class DefaultInitializationAssignment {
    int num;
    char letter;
    String text;
    double decimal;
    boolean flag;

    // Method to print instance variables with default values
    public void printVariables() {
        System.out.println("Integer: " + num);        // Default: 0
        System.out.println("Character: " + letter);   // Default: empty char (Unicode '\u0000')
        System.out.println("String: " + text);        // Default: null
        System.out.println("Double: " + decimal);     // Default: 0.0
        System.out.println("Boolean: " + flag);       // Default: false
    }

    public void printLocalVariables() {
        // Local variables must be initialized before use, hence the following lines would cause a compile error.
        // int localInt; // uninitialized local variable
        // char localChar; // uninitialized local variable
        // String localText; // uninitialized local variable
        // double localDecimal; // uninitialized local variable
        // boolean localFlag; // uninitialized local variable
        // System.out.println("Local Integer: " + localInt); // This will cause an error
        // System.out.println("Local Character: " + localChar); // This will cause an error
        // System.out.println("Local String: " + localText); // This will cause an error
        // System.out.println("Local Double: " + localDecimal); // This will cause an error
        // System.out.println("Local Boolean: " + localFlag); // This will cause an error

        /*
         * Local variables must be initialized before they are used. Otherwise, a compile-time error will occur.
         * In Java, local variables do not have default values and must be assigned a value before being accessed.
         */
    }
}
