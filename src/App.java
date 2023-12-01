public class App {
    public static void main(String[] args) {
        int[] l1 = {10, 1, 10, 10};
        int[] h1 = {5, 50, 5, 1};
        // Answer should be: 0 + 50 + 10 + 10 = 70
        
        int[] l2 = {10, 1, 10, 10};
        int[] h2 = {51, 50, 5, 1};
        // Answer should be: 51 + 1 + 10 + 10 = 72
        
        int[] l3 = {10, 1, 10, 10};
        int[] h3 = {5, 50, 500, 1};
        // Answer should be: 10 + 0 + 500 + 10 = 520
        
        int[] l4 = {50, 50, 50, 50};
        int[] h4 = {1, 1, 1, 1};
        // Answer should be: 50 + 50 + 50 + 50 = 200
        
        int[] l5 = {1, 1, 1, 1};
        int[] h5 = {50, 50, 50, 50};
        // Answer should be: 50 + 1 + 0 + 50 = 101

        System.out.println("Testing Scopel's example:");
        Solution.solveP1(l1, h1);
        System.out.println("Testing our counter-example (Problem 1-1):");
        Solution.solveP1(l2, h2);
        System.out.println("Testing a counter-example for our inicial code:");
        Solution.solveP1(l3, h3);
        System.out.println("Testing an all-low example:");
        Solution.solveP1(l4, h4);
        System.out.println("Testing an all-high example:");
        Solution.solveP1(l5, h5);
    }
}
