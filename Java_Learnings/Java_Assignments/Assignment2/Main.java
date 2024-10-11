package Java_Assignments.Assignment2;
import java.util.Scanner;

import static Java_Assignments.Assignment2.AlphabetChecker.containsAllLetters;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String defaultInput = "The quick brown fox jumps over the lazy dog";
            System.out.println("Default input: " + defaultInput);
            System.out.println("Contains all letters: " + containsAllLetters(defaultInput));

            System.out.print("Enter a string to check if it contains all letters of the alphabet: ");
            String userInput = scanner.nextLine();
            System.out.println("Contains all letters: " + containsAllLetters(userInput));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
