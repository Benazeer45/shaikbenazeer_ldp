package Java_Assignments.Assignment5.Benazeer.assignment.singleton;

public class SingletonExample {
    private static SingletonExample instance = null;  // Static instance variable (lazy initialization)
    private String message;  // Non-static String member variable

    // Private constructor to prevent instantiation from outside
    private SingletonExample() {}

    public static SingletonExample createInstance(String msg) {
        if (instance == null) { 
            instance = new SingletonExample();  
            instance.message = msg;  
        }
        return instance;  
    }

    public void printMessage() {
        System.out.println("Message: " + message);
    }
}
