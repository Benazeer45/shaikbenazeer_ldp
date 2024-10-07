package Core_Java.CoreJava;

public class ReturnTypes_MethodParameters {

    public int add(int a, int b) {
        return a + b;
    }
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        // Creating an instance of the class
        ReturnTypes_MethodParameters obj = new ReturnTypes_MethodParameters();

        int sum = obj.add(5, 10);
        System.out.println("Sum: " + sum);

        String greeting = obj.greet("Alice");
        System.out.println(greeting);

        obj.displayMessage("This is a message.");
    }
}
