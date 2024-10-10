package Java_Assignments.Lambdas_Streams.JavaLambdaBasics;

@FunctionalInterface
interface Addable {
    int add(int a, int b);
}

public class AddableExample {

    public static void main(String[] args) {
        // Without Lambda
        Addable ad1 = new Addable() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Addition without lambda: " + ad1.add(5, 10));

        // With Lambda
        Addable ad2 = (a, b) -> a + b;
        System.out.println("Addition with lambda: " + ad2.add(15, 20));
    }
}

