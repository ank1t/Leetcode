import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return f(m - 1, n - 1, grid);
    }

    //Plain recursion
    int f(int i, int j, int[][] grid) {
        if(i == 0 && j == 0) return grid[i][j];
        else if(i < 0 || j < 0) return 1_000_000;

        int up = f(i - 1, j, grid);
        int left = f(i, j - 1, grid);

        up += grid[i][j];
        left += grid[i][j];

        return Math.min(up, left);
    }

    //Recursion + Memoization
    int f1(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0) return grid[i][j];
        else if(i < 0 || j < 0) return 1_000_000;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f2(i - 1, j, grid, dp);
        int left = f2(i, j - 1, grid, dp);

        up += grid[i][j];
        left += grid[i][j];

        return dp[i][j] = Math.min(up, left);
    }

    //Tabulation
    int f3(int m, int n, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];
        prev[0] = grid[0][0];
        for(int i = 1;i < n;i++) {
            prev[i] = prev[i - 1] + grid[0][i];
        }

        for(int i = 1;i < m;i++) {
            int[] cur = new int[n];
            for(int j = 0;j < n;j++) {
                int up = prev[j];
                int left = j > 0 ? cur[j - 1] : 1_000_000;
                up += grid[i][j];
                if(left != 1_000_000) left += grid[i][j];
                cur[j] = Math.min(up, left);
            }
            prev = cur;
        }
        return prev[n -1];
    }

    //Space optimization
    int f4(int[][] grid, int m, int n) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];
        prev[0] = grid[0][0];
        for(int i = 1;i < n;i++) {
            prev[i] = prev[i - 1] + grid[0][i];
        }

        for(int i = 1;i < m;i++) {
            int cur = 1_000_000;
            for(int j = 0;j < n;j++) {
                int up = prev[j];
                int left = cur;
                up += grid[i][j];
                if(j != 0) left += grid[i][j];
                cur = Math.min(up, left);
                prev[j] = cur;
            }
        }
        return prev[n -1];
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid2 = new int[][] {{1,2,3},{4,5,6}};
        int[][] grid3 = new int[][] {{1,2,3}};
        System.out.println(sol.minPathSum(grid3));
    }
}