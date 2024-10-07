package Java_Assignments.Assignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileSearcher fileSearcher = new FileSearcher();

        System.out.println("Enter your home directory: ");
        String homeDirectory = scanner.nextLine();

        while (true) {
            System.out.println("Enter a regular expression to search for files (or type 'exit' to quit): ");
            String regex = scanner.nextLine();

            if (regex.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            fileSearcher.searchFiles(homeDirectory, regex);
        }

        scanner.close();
    }
}

