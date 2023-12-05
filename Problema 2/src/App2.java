public class App2 {
    public static void main(String[] args) {
        int[] w0 = {  5, 2, 1,  6,  7 };
        int[] v0 = { 18, 6, 1, 22, 28 };
        int i0 = 5;
        int mW0 = 11;
        /*  New order should be : w [ 7,  6,  5, 2, 1]
                                  v [28, 22, 18, 6, 1]
           Answer should be: 40 ->  [ 0,  1,  1, 0, 0]   */

        int[] w1 = {  4,  7,  5,  3 };
        int[] v1 = { 40, 42, 25, 12 };
        int i1 = 4;
        int mW1 = 10;
        /*  New order should be : w [ 4,  7,  5,  3]
                                  v [40, 42, 25, 12]
           Answer should be: 65 ->  [ 1,  0,  1,  0]   */

        int[] w2 = { 1, 2, 5, 6 };
        int[] v2 = { 2, 3, 4, 5 };
        int i2 = 4;
        int mW2 = 8;
        /*  New order should be : w [1, 2, 6, 5]
                                  v [2, 3, 5, 4]
           Answer should be: 9 ->   [1, 1, 0, 1]   */

        int[] w3 = { 4,  7,  8,  9 };
        int[] v3 = { 7, 10, 12, 15 };
        int i3 = 4;
        int mW3 = 19;
        /*  New order should be : w [4,  9,  8,  7]
                                  v [7, 15, 12, 10]
           Answer should be: 29 ->  [1,  0,  1,  1]   */

        int[] w4 = { 3, 6,  8, 10, 12 };
        int[] v4 = { 4, 7, 10, 14, 18 };
        int i4 = 5;
        int mW4 = 20;
        /*  New order should be : w [12, 10, 3,  8, 6]
                                  v [18, 14, 4, 10, 7]
           Answer should be: 28 ->  [ 1,  0, 0,  1, 0]   */

        int[] w5 = { 1, 2, 3,  4,  5 };
        int[] v5 = { 1, 2, 3, 10 };
        int i5 = 0;
        int mW5 = 0;

        printBlue("Scopel's example 1 (PDF):");
        P2Solution.solveP2(i0, w0, v0, mW0);
        printBlue("\nScopel's example 2 (Slides):");
        P2Solution.solveP2(i1, w1, v1, mW1);
        printBlue("\nRandom example 1:");
        P2Solution.solveP2(i2, w2, v2, mW2);
        printBlue("\nRandom example 2:");
        P2Solution.solveP2(i3, w3, v3, mW3);
        printBlue("\nRandom example 3:");
        P2Solution.solveP2(i4, w4, v4, mW4);
        printBlue("\nInvalid values example:");
        P2Solution.solveP2(i5, w5, v5, mW5);
    }

    private static void printBlue(String printable) {
        String blueString = "\u001B[34m";
        String resetColour= "\u001B[0m";
        System.out.printf("%s%s%s%n", blueString, printable, resetColour);
    }
}
