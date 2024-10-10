package Java_Assignments.Lambdas_Streams.JavaLambdaBasics;

@FunctionalInterface
interface Sayable {
    String say(String message);
}

public class SayableExample {

    public static void main(String[] args) {
        // Without Lambda
        Sayable s1 = new Sayable() {
            @Override
            public String say(String message) {
                return "Hello, " + message;
            }
        };
        System.out.println(s1.say("World"));

        // With Lambda
        Sayable s2 = (message) -> "Hello, " + message;
        System.out.println(s2.say("Lambda"));
    }
}
