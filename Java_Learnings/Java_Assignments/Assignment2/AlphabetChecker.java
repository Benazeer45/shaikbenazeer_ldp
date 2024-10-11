package Java_Assignments.Assignment2;

import java.util.HashSet;

public class AlphabetChecker {

    public static boolean containsAllLetters(String input) {
        if (input.length() < 26) {
            return false;
        }

        HashSet<Character> lettersSet = new HashSet<>();
        input = input.toLowerCase();

        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lettersSet.add(c);
            }
        }

        return lettersSet.size() == 26;
    }

}

/*
Time Complexity: O(n), where n is the length of the input string.
We traverse the string once, and adding to the HashSet is O(1) on average.

Space Complexity: O(1), since the HashSet will store at most 26 letters.
*/
