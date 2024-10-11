package Java_Assignments.Lambdas_Streams.JavaLambdaBasics;

@FunctionalInterface
interface Drawable {
    void draw();
}

public class DrawableExample {

    public static void main(String[] args) {
        // Without Lambda
        Drawable d1 = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing without lambda");
            }
        };
        d1.draw();

        // With Lambda
        Drawable d2 = () -> {
            System.out.println("Drawing with lambda");
        };
        d2.draw();
    }
}

