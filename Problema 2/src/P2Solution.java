import java.util.Arrays;

public class P2Solution {
    private P2Solution() {}

    public static void solveP2(int n, int wi[], int vi[], int W) {
        int itemAmount = n;
        int maxWeight = W;
        
        int[] weights;
        int[] values;

        // First, we check if values are valid
        if ((n <= 0) || (n != wi.length) || (n != vi.length) || (W <= 0)) {
            System.out.println("Invalid values");
            return;
        }

        // Then, we order items by value/weight ratio
        int[][] aux = orderByRatio(wi, vi);

        weights = aux[0];
        values = aux[1];

        // Finally, we calculate the solution using the branch and bound algorithm
        printMatrix(knapsackSolve(weights, values, itemAmount, maxWeight));
    }

    private static int[][] orderByRatio(int[] weights, int[] values) {
        int[][] items = new int[2][weights.length];
        double[] ratios = new double[weights.length];
        PairedValue[] pairs = new PairedValue[weights.length];

        for (int i = 0; i < weights.length; i++) { // Calculate ratios
            ratios[i] = ((double) values[i]) / weights[i];
        }

        for (int i = 0; i < weights.length; i++) { // Pair the ratios with the items
            pairs[i] = new PairedValue(weights[i], values[i], ratios[i]);
        }

        Arrays.sort(pairs); // Sort the pairs by ratio

        for (int i = 0; i < weights.length; i++) { // Unpair the pairs
            items[0][i] = pairs[i].a1;
            items[1][i] = pairs[i].a2;
        }

        return items;
    }

    private static int[][] knapsackSolve(int[] weights, int[] values, int itemAmount, int maxWeight) {
        int[][] matrix = new int[itemAmount + 1][maxWeight + 1];

        for (int i = 1; i <= itemAmount; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weights[i - 1] > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(
                        matrix[i - 1][j],
                        matrix[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int[] weights = { 4, 7, 5, 3 };
        int[] values =  { 40, 42, 25, 12 };
        int itemAmount = 4;
        int maxWeight = 10;

        solveP2(itemAmount, weights, values, maxWeight);
    }
}