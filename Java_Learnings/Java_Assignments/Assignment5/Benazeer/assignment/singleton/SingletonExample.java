package Java_Assignments.Assignment5.Benazeer.assignment.singleton;

public class SingletonExample {
    private String message;  // Non-static String member variable

    // Static method to create and initialize the SingletonExample instance
    // Static method to initialize the member variable and return an instance of the class
    public static SingletonExample createInstance(String msg) {
        SingletonExample instance = new SingletonExample();
        instance.message = msg;
        return instance;
    }

    // Non-static method to print the message
    public void printMessage() {
        System.out.println("Message: " + message);
    }
}
