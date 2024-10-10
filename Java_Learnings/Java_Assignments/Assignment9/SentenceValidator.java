package Java_Assignments.Assignment9;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SentenceValidator {

    // Regular expression to check if a sentence starts with a capital letter and ends with a period
    private static final String REGEX = "^[A-Z].*\\.$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Default test sentences
        String[] defaultSentences = {
                "This is a valid sentence.",  // Valid
                "this is an invalid sentence.", // Invalid: starts with lowercase
                "Another valid sentence.",      // Valid
                "Yet another invalid sentence",  // Invalid: no ending period
                "   Leading spaces are okay."   // Invalid: leading spaces
        };

        // Validate default sentences
        System.out.println("Validating default sentences:");
        for (String sentence : defaultSentences) {
            validateAndPrint(sentence);
        }

        System.out.println("\nEnter sentences to validate (type 'exit' to quit):");
        while (true) {
            System.out.print("Input: ");
            String userInput = scanner.nextLine();
            if ("exit".equalsIgnoreCase(userInput)) {
                System.exit(0);
            }
            validateAndPrint(userInput);
        }

    }

    // Method to validate and print the result
    public static void validateAndPrint(String sentence) {
        try {
            validateSentence(sentence);
            System.out.println("\"" + sentence + "\" is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("\"" + sentence + "\" is invalid: " + e.getMessage());
        }
    }

    // Method to validate the sentence
    public static void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Sentence cannot be null.");
        }
        if (sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be empty or whitespace.");
        }
        if (!isValidSentence(sentence)) {
            throw new IllegalArgumentException("Sentence must start with a capital letter and end with a period.");
        }
    }

    // Method to check if the sentence matches the regex pattern
    public static boolean isValidSentence(String sentence) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(sentence);
        return matcher.matches();
    }
}

