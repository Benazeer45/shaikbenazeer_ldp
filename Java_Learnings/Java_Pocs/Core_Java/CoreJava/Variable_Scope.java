package Core_Java.CoreJava;

public class Variable_Scope {
    // Class variable (static variable)
    static int classVariable = 10;

    // Instance variable
    int instanceVariable = 20;

    public void demonstrateLocalScope() {
        int localVariable = 30;
        System.out.println("Local Variable: " + localVariable);
    }

    public void demonstrateInstanceAndClassScope() {
        System.out.println("Class Variable: " + classVariable); // Accessing class variable
        System.out.println("Instance Variable: " + instanceVariable); // Accessing instance variable
    }

    public static void main(String[] args) {
        Variable_Scope scope = new Variable_Scope();

        scope.demonstrateLocalScope();

        scope.demonstrateInstanceAndClassScope();
    }
}
