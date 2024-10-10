package Java_Assignments.Assignment11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input file name: ");
        String inputFileName = scanner.nextLine();

        String outputFileName = "D:/Java/Java_Assignments/Assignment11/character_count.txt";


        // Map to store character counts
        Map<Character, Integer> charCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            int character;

            while ((character = reader.read()) != -1) {
                char currentChar = (char) character;

                // Update character count in the map
                charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue());
                    writer.newLine();
                }
            }

            System.out.println("Character count has been saved to " + outputFileName);

        } catch (IOException e) {
            System.err.println("Error while processing the file: " + e.getMessage());
        }
        scanner.close();
    }
}
