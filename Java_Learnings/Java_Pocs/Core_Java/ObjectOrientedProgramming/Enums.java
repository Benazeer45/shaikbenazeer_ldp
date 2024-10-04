package Core_Java.ObjectOrientedProgramming;

// Define an enum for days of the week
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

// Class to demonstrate the usage of the Day enum
public class Enums {
    public static void main(String[] args) {
        // Accessing an enum value
        Day today = Day.MONDAY;

        // Print the current day
        System.out.println("Today is: " + today);

        // Using a switch statement with an enum
        switch (today) {
            case SUNDAY:
                System.out.println("It's the weekend!");
                break;
            case MONDAY:
                System.out.println("Back to work!");
                break;
            case TUESDAY:
                System.out.println("It's Tuesday!");
                break;
            case WEDNESDAY:
                System.out.println("Midweek already!");
                break;
            case THURSDAY:
                System.out.println("Almost the weekend!");
                break;
            case FRIDAY:
                System.out.println("It's Friday, yay!");
                break;
            case SATURDAY:
                System.out.println("Enjoy your weekend!");
                break;
            default:
                System.out.println("Not a valid day!");
                break;
        }

        // Loop through all enum values
        System.out.println("\nDays of the week:");
        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }
}
