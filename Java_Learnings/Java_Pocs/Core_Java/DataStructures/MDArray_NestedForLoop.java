package Core_Java.DataStructures;

public class MDArray_NestedForLoop {

    public static void main(String[] args) {
        // One-dimensional array
        int[] oneDArray = {10, 20, 30, 40, 50};

        // Two-dimensional array (double array)
        double[][] twoDArray = {
                {1.1, 2.2, 3.3},
                {4.4, 5.5, 6.6},
                {7.7, 8.8, 9.9}
        };

        System.out.println("One-dimensional Array values:");
        for (int i = 0; i < oneDArray.length; i++) {
            System.out.println("oneDArray[" + i + "]: " + oneDArray[i]);
        }

        System.out.println("\nTwo-dimensional Array values:");
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.println("twoDArray[" + i + "][" + j + "]: " + twoDArray[i][j]);
            }
        }
    }
}
