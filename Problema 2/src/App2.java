public class App2 {
    public static void main(String[] args) {
        int[] weights = { 4, 7, 5, 3 };
        int[] values =  { 40, 42, 25, 12 };
        int itemAmount = 4;
        int maxWeight = 10;

        P2Solution.solveP2(itemAmount, weights, values, maxWeight);
    }
}
