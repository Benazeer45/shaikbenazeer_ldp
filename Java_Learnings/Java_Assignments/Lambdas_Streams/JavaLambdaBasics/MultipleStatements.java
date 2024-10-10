package Java_Assignments.Lambdas_Streams.JavaLambdaBasics;


public class MultipleStatements {
    public static void main(String[] args) {
        // You can pass multiple statements in lambda expression
        Sayable person = (message) -> {
            String str1 = "I would like to say, ";
            String str2 = str1 + message;
            return str2;
        };
        System.out.println(person.say("time is precious.")); // Output: I would like to say, time is precious.
    }
}
