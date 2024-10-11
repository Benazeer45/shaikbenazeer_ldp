package Java_Assignments.Lambdas_Streams.JavaLambdaBasics;

@FunctionalInterface
interface AddableWithSingleParam {
    int add(int a);
}

public class AddableWithSingleParamExample {

    public static void main(String[] args) {
        // Without Lambda
        AddableWithSingleParam ad1 = new AddableWithSingleParam() {
            @Override
            public int add(int a) {
                return a + 10;
            }
        };
        System.out.println("Addition without lambda: " + ad1.add(5));

        // With Lambda
        AddableWithSingleParam ad2 = (a) -> a + 20;
        System.out.println("Addition with lambda: " + ad2.add(10));
    }
}

