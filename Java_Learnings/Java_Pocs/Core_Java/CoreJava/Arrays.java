package Core_Java.CoreJava;

public class Arrays {
    public static void main(String[] args) {
        int normalVariable = 10;

        int[] numbers = new int[5]; // Declaring an array of size 5
        int[] integers = {1, 2, 3, 4, 5}; // Initializing an array with values

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("Normal Variable: " + normalVariable);

        System.out.println("Numbers array values:");
        System.out.println("numbers[0]: " + numbers[0]);
        System.out.println("numbers[1]: " + numbers[1]);
        System.out.println("numbers[2]: " + numbers[2]);
        System.out.println("numbers[3]: " + numbers[3]);
        System.out.println("numbers[4]: " + numbers[4]);

        System.out.println("Integers array values:");
        for (int i = 0; i < integers.length; i++) {
            System.out.println("integers[" + i + "]: " + integers[i]);
        }
    }
}
