package Core_Java.CoreJava;

public class If_Statement {
    public static void main(String[] args) {
        int number = 5;

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        System.out.println("Counting down from " + number + ":");
        while (number >= 0) {
            if (number % 2 == 0) {
                System.out.println(number + " is even.");
            } else {
                System.out.println(number + " is odd.");
            }
            number--;
        }
    }
}
