package Java_Assignments.Assignment3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class PingUtility {

    public double calculateMedianPingTime(String host) {
        ArrayList<Double> pingTimes = new ArrayList<>();
        String command = "ping -n 4 " + host;

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    String[] parts = line.split("time=");
                    if (parts.length > 1) {
                        String timePart = parts[1].split("ms")[0].trim();
                        pingTimes.add(Double.parseDouble(timePart));
                    }
                }
            }

            process.waitFor();
        } catch (Exception e) {
            System.out.println("Error while executing ping command: " + e.getMessage());
            return -1;
        }

        return calculateMedian(pingTimes);
    }

    private double calculateMedian(ArrayList<Double> numbers) {
        if (numbers.isEmpty()) {
            return -1;
        }

        Collections.sort(numbers);
        int size = numbers.size();
        if (size % 2 == 0) {
            return (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2;
        } else {
            return numbers.get(size / 2);
        }
    }
}

