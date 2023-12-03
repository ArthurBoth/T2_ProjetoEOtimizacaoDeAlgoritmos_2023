import java.util.Arrays;

public class P2Solution {
    private P2Solution() {}

    /**
     * Solves the assignment's problem 2
     * @param n  Number of items
     * @param wi Individual weights of every item
     * @param vi Individual values of every item
     * @param W  Maximum weight the knapsack can hold
     * 
     * Complexity: O(n * W)
     */
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
        knapsackSolve(weights, values, itemAmount, maxWeight);
    }

    /**
     * Orders items by value/weight ratio
     * @param weights Individual weights of every item
     * @param values  Individual values of every item
     * 
     * @return        A matrix with the weights in the first row and the values in the second row, both ordered by ratio
     * 
     * Complexity: O(n * log(n))
     */
    private static int[][] orderByRatio(int[] weights, int[] values) {
        int[][] items = new int[2][weights.length];
        PairedValue[] pairs = new PairedValue[weights.length];

        for (int i = 0; i < weights.length; i++) { // Pair the values and weights
            pairs[i] = new PairedValue(weights[i], values[i]);
        }

        Arrays.sort(pairs); // Sort the pairs by ratio

        for (int i = 0; i < weights.length; i++) { // Unpair the values and weights
            items[0][i] = pairs[i].weight;
            items[1][i] = pairs[i].value;
        }

        return items;
    }

    /**
     * Solves the knapsack problem using the branch and bound algorithm
     * @param weights    Individual weights of every item
     * @param values     Individual values of every item
     * @param itemAmount Number of items
     * @param maxWeight  Maximum weight the knapsack can hold
     * 
     * Complexity: O(n * W)
     */
    private static void knapsackSolve(int[] weights, int[] values, int itemAmount, int maxWeight) {
        /*
            First, we create a tree with all possible combinations of items and weights 
            (solution will always be in the last row and column)
         */

        int[][] tree = new int
                           [itemAmount + 1] // One row for each ammount possible from 0 to all items
                           [maxWeight + 1]; // One column for each weight possible from 0 to the maximum capacity
        int takeItem; // The value of the knapsack if we take the item
        int dontTakeItem; // The value of the knapsack if we don't take the item

        for (int i = 1; i <= itemAmount; i++) { // i starts as 1 because the first row is always 0
            for (int j = 1; j <= maxWeight; j++) { // j starts as 1 because the first column is always 0
                dontTakeItem = tree[i - 1][j]; // value stays the same if we don't take the item

                if (weights[i - 1] > j) { // If the item is too heavy, we can't take it
                    tree[i][j] = dontTakeItem;
                } else {
                    takeItem = tree[i - 1][j - weights[i - 1]] + values[i - 1]; // value increases if we take the item
                    tree[i][j] = Math.max(takeItem, dontTakeItem); // We take the best option
                }
            }
        }

        /*
            Then, we determine which items are in the knapsack
        */
        int answer = tree[itemAmount][maxWeight];
        boolean[] itemInKnapsack = new boolean[itemAmount];
        while (itemAmount > 0) {
            if (tree[itemAmount][maxWeight] != tree[itemAmount - 1][maxWeight]) { // Check if the item is in the knapsack
                itemInKnapsack[itemAmount - 1] = true; // registers the item is in the knapsack
                maxWeight -= weights[itemAmount - 1]; // adjusts the maximum weight
            } else {
                itemInKnapsack[itemAmount - 1] = false; // registers the item isn't in the knapsack
            }
            itemAmount--;
        }

        /*
            Finally, we print the solution
        */
        for (int i = 0; i < itemInKnapsack.length; i++) {
            if (itemInKnapsack[i]) {
                System.out.printf("\u001B[33mItem %d is in the knapsack\u001B[0m%n", i + 1);
            } else {
                System.out.printf("\u001B[31mItem %d is not in the knapsack\u001B[0m%n", i + 1);
            }
        }
        System.out.printf("\u001B[32mTotal value: %d\u001B[0m%n", answer);
    }
}