package exp;

import java.util.Random;

public class Exp1_3 {
    public static void getGrid(int[][] grid) {
        Random r = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = r.nextInt(100);
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int n = 5, m = 7;
        int[][] grid = new int[n][m];
        getGrid(grid);
        int mx = 0, my = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > grid[mx][my]) {
                    mx = i;
                    my = j;
                }
            }
        }
        System.out.format("Max = grid[%d][%d] = %d",
                mx, my, grid[mx][my]);
    }
}
