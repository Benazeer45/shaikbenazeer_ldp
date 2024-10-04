package Core_Java.RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtendedRegEx {

    public static void main(String[] args) {
        String text = "My phone number is 123-456-7890. You can also reach me at 321-654-0987 or @myhandle.";

        // 1. Predefined Character Classes
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Phone Numbers Found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // 2. Named Groups
        Pattern namedGroupPattern = Pattern.compile("(?<areaCode>\\d{3})-(?<localNumber>\\d{3}-\\d{4})");
        Matcher namedGroupMatcher = namedGroupPattern.matcher(text);
        while (namedGroupMatcher.find()) {
            System.out.println("Area Code: " + namedGroupMatcher.group("areaCode"));
            System.out.println("Local Number: " + namedGroupMatcher.group("localNumber"));
        }

        // 3. Lookbehind Assertion
        Pattern lookbehindPattern = Pattern.compile("(?<=@)\\w+");
        Matcher lookbehindMatcher = lookbehindPattern.matcher(text);
        System.out.println("Username found:");
        while (lookbehindMatcher.find()) {
            System.out.println(lookbehindMatcher.group());
        }

        // 4. Non-Capturing Groups
        String nonCapturingRegex = "(?:cat|dog) is a pet.";
        System.out.println("Regex with non-capturing group: " + nonCapturingRegex);
    }
}

