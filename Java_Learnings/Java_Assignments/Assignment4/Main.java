package Java_Assignments.Assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        KYCFormProcessor processor = new KYCFormProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of input lines:");
        int n = Integer.parseInt(scanner.nextLine());

        List<String> inputs = new ArrayList<>();

        System.out.println("Enter the signup date and current date in the format 'dd-MM-yyyy dd-MM-yyyy':");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            inputs.add(input);
        }

        for (String input : inputs) {
            String[] dates = input.split(" ");
            if (dates.length == 2) {
                processor.processKYCForm(dates[0], dates[1]);
            } else {
                System.out.println("Invalid input format. Please enter two dates separated by a space.");
            }
        }

        scanner.close();
    }
}
