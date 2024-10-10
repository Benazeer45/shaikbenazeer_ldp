package Java_Assignments.Assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class KYCFormProcessor {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public LocalDate parseDate(String dateStr) throws IllegalArgumentException {
        try {
            return LocalDate.parse(dateStr, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'dd-MM-yyyy'.", e);
        }
    }

    public String formatDate(LocalDate date) {
        return date.format(FORMATTER);
    }

    public LocalDate getAnniversary(LocalDate signupDate, LocalDate currentDate) {
        return LocalDate.of(currentDate.getYear(), signupDate.getMonth(), signupDate.getDayOfMonth());
    }

    public String getKYCRange(LocalDate signupDate, LocalDate currentDate) {
        LocalDate anniversary = getAnniversary(signupDate, currentDate);
        LocalDate startRange = anniversary.minusDays(30);
        LocalDate endRange = anniversary.plusDays(30);

        if (currentDate.isBefore(startRange)) {
            return "No range";
        }

        LocalDate validEndDate = currentDate.isBefore(endRange) ? currentDate : endRange;
        return formatDate(startRange) + " " + formatDate(validEndDate);
    }

    public void processKYCForm(String signupDateStr, String currentDateStr) {
        try {
            LocalDate signupDate = parseDate(signupDateStr);
            LocalDate currentDate = parseDate(currentDateStr);

            if (currentDate.isBefore(signupDate)) {
                System.out.println("No range");
                return;
            }

            String range = getKYCRange(signupDate, currentDate);
            System.out.println(range);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}
