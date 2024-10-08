package Java_Assignments.Assignment1;

import java.io.File;
import java.util.regex.Pattern;

public class RegexFileFilter {

    private Pattern pattern;

    public RegexFileFilter(String regex) {
        try {
            this.pattern = Pattern.compile(regex);
        } catch (Exception e) {
            System.out.println("Invalid regular expression. Please try again.");
        }
    }

    public boolean match(File file) {
        if (pattern == null) {
            return false;
        }
        return pattern.matcher(file.getName()).matches();
    }
}

