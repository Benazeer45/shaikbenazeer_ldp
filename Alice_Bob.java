import java.io.*;
import java.util.*;

public class Alice_Bob {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        // Reading the sequence directly from the user as a single line
        System.out.println("Enter the sequence of numbers separated by spaces:");
        String inputLine = sc.nextLine(); 
        
        // Check if the input string is empty
        if (inputLine.trim().isEmpty()) {
            throw new IllegalArgumentException("You need to provide a sequence of elements.");
        }

        String[] inputArray = inputLine.split(" "); // Splitting the input line into individual strings
        List<Integer> sequence = new ArrayList<>();
        for (String numStr : inputArray) {
            sequence.add(Integer.parseInt(numStr)); // Converting strings to integers and adding to the list
        }

        int n = sequence.size();
        if (n % 2 != 0) {
            System.out.println("Please give an even length sequence.");
            return;
        }

        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            if ((sequence.get(i) & 1) == 1) odd++;
            else even++;
        }

        int[][][] dp = new int[101][101][2]; // [odd][even][Alice sum parity 0 even, 1 odd] = 1 win, 0 lose
        for (int i = 0; i < 101; i++) {
            dp[0][i][0] = 1;
            dp[0][i][1] = 0;
        }
        for (int i = 0; i < 101; i++) {
            dp[1][i][1] = 1;
            if ((i & 1) == 1) dp[1][i][0] = 1;
            else dp[1][i][0] = 0;
        }
        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 2; k++) {
                    boolean takenodd = false, takeneven = false;

                    // Alice takes odd
                    boolean lose1 = false;

                    // Bob takes odd
                    lose1 |= (dp[i-2][j][k^1] == 0);
                    takenodd = true;

                    // Bob takes even
                    if (j - 1 > -1) {
                        lose1 |= (dp[i-1][j-1][k^1] == 0);
                        takenodd = true;
                    }

                    // Alice takes even
                    boolean lose2 = false;
                    if (j > 0) {
                        // Bob takes even
                        if (j - 2 > -1) {
                            lose2 |= (dp[i][j-2][k] == 0);
                            takeneven = true;
                        }
                        // Bob takes odd
                        if (i-1 > -1) {
                            lose2 |= (dp[i-1][j-1][k] == 0);
                            takeneven = true;
                        }
                    }

                    boolean AliceLoses;
                    if (takeneven && takenodd) AliceLoses = lose1 && lose2;
                    else AliceLoses = lose1 || lose2;

                    dp[i][j][k] = AliceLoses ? 0 : 1;
                }
            }
        }
        
        // Output the result
        pw.println(dp[odd][even][0] == 1 ? "Alice" : "Bob");
        pw.flush(); // Ensure output is flushed
    }
}
