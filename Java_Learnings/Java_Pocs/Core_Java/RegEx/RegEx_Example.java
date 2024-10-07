package Core_Java.RegEx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_Example {


        public static void main(String[] args) {
            // Sample string for regex operations
            String sampleText = "Hello World! My email is example@mail.com. " +
                    "Contact me at (123) 456-7890 or visit my site at http://example.com. " +
                    "My zip code is 12345-6789.";

            // 1. Pattern and Matcher
            System.out.println("1. Pattern and Matcher:");
            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            Matcher matcher = pattern.matcher(sampleText);
            while (matcher.find()) {
                System.out.println("Found word: " + matcher.group());
            }
            System.out.println();

            // 2. Character Classes
            System.out.println("2. Character Classes:");
            String charClassRegex = "[aeiou]"; // Matches vowels
            Matcher charClassMatcher = Pattern.compile(charClassRegex).matcher(sampleText);
            System.out.println("Vowels found:");
            while (charClassMatcher.find()) {
                System.out.print(charClassMatcher.group() + " ");
            }
            System.out.println("\n");

            // 3. Quantifiers
            System.out.println("3. Quantifiers:");
            String quantifierRegex = "\\d{3}"; // Matches exactly three digits
            Matcher quantifierMatcher = Pattern.compile(quantifierRegex).matcher(sampleText);
            System.out.println("Found three-digit number:");
            while (quantifierMatcher.find()) {
                System.out.println("Three digits: " + quantifierMatcher.group());
            }
            System.out.println();

            // 4. Anchors
            System.out.println("4. Anchors:");
            String anchorRegex = "^Hello"; // Matches 'Hello' at the start
            Matcher anchorMatcher = Pattern.compile(anchorRegex).matcher(sampleText);
            System.out.println("Does the text start with 'Hello'? " + anchorMatcher.find());
            System.out.println();

            // 5. Groups and Capturing
            System.out.println("5. Groups and Capturing:");
            String groupRegex = "(\\d{3})-(\\d{4})"; // Matches zip code format
            Matcher groupMatcher = Pattern.compile(groupRegex).matcher("Zip code: 12345-6789.");
            if (groupMatcher.find()) {
                System.out.println("Found zip code: " + groupMatcher.group());
                System.out.println("Area code: " + groupMatcher.group(1));
                System.out.println("Local code: " + groupMatcher.group(2));
            }
            System.out.println();

            // 6. Lookahead and Lookbehind Assertions
            System.out.println("6. Lookahead and Lookbehind Assertions:");
            String lookaheadRegex = "\\d(?=\\d{4})"; // Matches a digit followed by 4 digits
            Matcher lookaheadMatcher = Pattern.compile(lookaheadRegex).matcher("Call me at (123) 456-7890.");
            System.out.println("Lookahead match:");
            while (lookaheadMatcher.find()) {
                System.out.println("Found: " + lookaheadMatcher.group());
            }
            System.out.println();

            // 7. Flags for Case Sensitivity
            System.out.println("7. Flags for Case Sensitivity:");
            String caseInsensitiveRegex = "(?i)hello"; // Case insensitive match
            Matcher caseInsensitiveMatcher = Pattern.compile(caseInsensitiveRegex).matcher("Hello World!");
            System.out.println("Found (case insensitive): " + caseInsensitiveMatcher.find());
            System.out.println();

            // 8. Replacement
            System.out.println("8. Replacement:");
            String replacedText = sampleText.replaceAll("\\d{3}-\\d{4}", "[REDACTED]");
            System.out.println("Text after redacting phone numbers: " + replacedText);
            System.out.println();

            // 9. Splitting
            System.out.println("9. Splitting:");
            String splitText = "apple,banana;orange|grape";
            String[] fruits = splitText.split("[,;|]");
            System.out.println("Fruits after splitting:");
            for (String fruit : fruits) {
                System.out.println(fruit.trim());
            }
        }
    }
