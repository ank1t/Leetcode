import java.util.*;

/*
    1D array is space optimized to 2 vars
    2D array is space optimized to 1D arr
    3D array is space optimized to 2D arr
 */
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for(int[][] r1 : dp) {
            for(int[] r2 : r1) Arrays.fill(r2, -1);
        }
        return f(grid, 0, 0, m - 1, n, m, dp);
    }

    /*
        Always write out of bounds base case 1st
     */
    int f(int[][] grid, int row, int col1, int col2, int n, int m, int[][][] dp) {
        if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return -1_000_000;
        else if(row == n - 1) {
            if(col1 == col2) return grid[row][col1];
            return grid[row][col1] + grid[row][col2];
        }

        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int max = -1;
        for(int delta1 = -1;delta1 < 2;delta1++) {
            for(int delta2 = -1;delta2 < 2;delta2++) {
                int value = 0;
                if(col1 == col2) value += grid[row][col1];
                else value += grid[row][col1] + grid[row][col2];
                value += f(grid, row + 1, col1 + delta1, col2 + delta2, n, m, dp);
                max = Math.max(max, value);
            }
        }

        return dp[row][col1][col2] = max;
    }

    /* Tabulation*/

    int f2(int[][] grid, int n, int m) {
        int[][][] dp = new int[n][m][m];
        for(int j1 = 0;j1 < m;j1++) {
            for(int j2 = 0;j2 < m;j2++) {
                if(j1 == j2) dp[n - 1][j1][j2] = grid[n-1][j1];
                else dp[n - 1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i = n - 2;n >= 0;n--) {
            for(int j1 = 0;j1 < m;j1++) {
                for(int j2 = 0;j2 < m;j2++) {
                    int max = -1;
                    for(int delta1 = -1;delta1 < 2;delta1++) {
                        for(int delta2 = -1;delta2 < 2;delta2++) {
                            int value = 0;
                            if(j1 == j2) value += grid[i][j1];
                            else value += grid[i][j1] + grid[i][j2];
                            if(j1 + delta1 >= 0 && j1 + delta1 < m && j2 + delta2 >= 0 && j2 + delta2 < m)
                                value += dp[i + 1][j1 + delta1][j2 + delta2];
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}