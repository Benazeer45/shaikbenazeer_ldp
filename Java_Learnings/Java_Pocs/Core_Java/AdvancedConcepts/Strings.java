package Core_Java.AdvancedConcepts;

public class Strings {
    public static void main(String[] args) {
        int aNumber = 9;
        double aDouble = 5.75;
        String text = "Hello";
        String blank = " ";
        String moreText = "World";

        String concatenatedText = text + blank + moreText;
        String mixedConcatenation = text + blank + aNumber + blank + aDouble;

        System.out.println("Concatenated String: " + concatenatedText);
        System.out.println("Hi"+" "+"There");
        System.out.println("String with int and double: " + mixedConcatenation);
    }
}
