package Java_Assignments.Assignment3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the host to ping (e.g., google.com): ");
            String host = scanner.nextLine().trim();

            if (host.isEmpty()) {
                throw new IllegalArgumentException("Host cannot be empty.");
            }

            // Create PingUtility instance and calculate median ping time
            PingUtility pingUtility = new PingUtility();
            double medianPingTime = pingUtility.calculateMedianPingTime(host);

            if (medianPingTime >= 0) {
                System.out.printf("The median ping time to %s is %.2f ms%n", host, medianPingTime);
            } else {
                System.out.println("No valid ping times were recorded.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

