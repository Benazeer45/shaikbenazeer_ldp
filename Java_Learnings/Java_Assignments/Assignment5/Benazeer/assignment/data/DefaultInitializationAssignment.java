package Java_Assignments.Assignment5.Benazeer.assignment.data;

public class DefaultInitializationAssignment {
    int num;
    char letter;

    public void printVariables() {
        System.out.println("Integer: " + num); // prints default value (0)
        System.out.println("Character: " + letter); // prints default value (empty char)
    }

    public void printLocalVariables() {
        // Local variables must be initialized before use, hence the following lines would cause a compile error.
        // int localInt; // uninitialized local variable
        // char localChar; // uninitialized local variable
        // System.out.println("Local Integer: " + localInt); // This will cause an error, Error: localInt might not have been initialized
        // System.out.println("Local Character: " + localChar); // This will cause an error, Error: localChar might not have been initialized
        /*
         * Local variables must be initialized before they are used. otherwise, a compile-time error will occur.
         * In Java, local variables do not have default values and must be assigned a value before being accessed.
         */
    }
}
