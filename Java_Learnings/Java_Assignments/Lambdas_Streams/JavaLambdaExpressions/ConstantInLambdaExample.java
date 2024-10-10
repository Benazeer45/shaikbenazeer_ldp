package Java_Assignments.Lambdas_Streams.JavaLambdaExpressions;


public class ConstantInLambdaExample {
    final static String salutation = "Hello! ";

    public static void runExample() {
        GreetingService greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Mahesh");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}

