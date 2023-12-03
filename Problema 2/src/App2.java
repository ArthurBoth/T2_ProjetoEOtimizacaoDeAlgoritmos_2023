public class App2 {
    public static void main(String[] args) {
        int[] w1 = { 4,   7,  5,  3 };
        int[] v1 = { 40, 42, 25, 12 };
        int i1 = 4;
        int mW1 = 10;

        int[] w2 = { 1, 2, 5, 6 };
        int[] v2 = { 2, 3, 4, 5 };
        int i2 = 4;
        int mW2 = 8;

        int[] w3 = { 4,  7,  8,  9 };
        int[] v3 = { 7, 10, 12, 15 };
        int i3 = 4;
        int mW3 = 20;

        int[] w4 = { 3, 6,  8, 10, 12 };
        int[] v4 = { 4, 7, 10, 14, 18 };
        int i4 = 5;
        int mW4 = 20;

        int[] w5 = { 1, 2, 3,  4,  5 };
        int[] v5 = { 1, 2, 3, 10 };
        int i5 = 0;
        int mW5 = 0;

        System.out.println("Scopel's example:");
        P2Solution.solveP2(i1, w1, v1, mW1);
        System.out.println("\nRandom example 1:");
        P2Solution.solveP2(i2, w2, v2, mW2);
        System.out.println("\nRandom example 2:");
        P2Solution.solveP2(i3, w3, v3, mW3);
        System.out.println("\nRandom example 3:");
        P2Solution.solveP2(i4, w4, v4, mW4);
        System.out.println("\nInvalid values example:");
        P2Solution.solveP2(i5, w5, v5, mW5);
    }
}
