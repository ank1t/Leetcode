import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, 1_000_000_00);

        for(int i = 0;i < m;i++) {
            min = Math.min(min, f2(matrix, n, m, 0, i, dp));
        }
        return min;
    }

    //Recursion
    int f1(int[][] matrix, int n, int m, int row, int col) {
        if(col < 0 || col >= m) return 1_000_000_00;
        if(row == n - 1) return matrix[row][col];

        int down = matrix[row][col] + f1(matrix, n, m, row + 1, col);
        int downLeft = matrix[row][col] + f1(matrix, n, m, row + 1, col - 1);
        int downRight = matrix[row][col] + f1(matrix, n, m, row + 1, col + 1);

        return Math.min(down, Math.min(downLeft, downRight));
    }

    /*
        Recursion + Memoization
        int dp[][] = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, 1_000_000_00);

     */
    int f2(int[][] matrix, int n, int m, int row, int col, int[][] dp) {
        if(col < 0 || col >= m) return 1_000_000_00;
        if(row == n - 1) return matrix[row][col];

        if(dp[row][col] != 1_000_000_00) return dp[row][col];

        int down = matrix[row][col] + f2(matrix, n, m, row + 1, col, dp);
        int downLeft = matrix[row][col] + f2(matrix, n, m, row + 1, col - 1, dp);
        int downRight = matrix[row][col] + f2(matrix, n, m, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(down, Math.min(downLeft, downRight));
    }

    int f3(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, 1_000_000);
        dp[0] = matrix[0];

        for(int i = 1;i < n;i++) {
            for(int j = 0;j < m;j++) {
                int down = Integer.MAX_VALUE, downLeft = Integer.MAX_VALUE, downRight = Integer.MAX_VALUE;

                down = matrix[i][j] + dp[i - 1][j];
                if(j > 0) downLeft = matrix[i][j] + dp[i - 1][j - 1];
                if(j < m - 1) downRight = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(dp[i][j], Math.min(down, Math.min(downLeft, downRight)));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i < m;i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        return min;
    }

    int f4(int[][] matrix, int n, int m) {
        int[] dp = new int[m];
        dp = matrix[0];

        for(int i = 1;i < n;i++) {
            int[] cur = new int[m];
            Arrays.fill(cur, 1_000_000);

            for(int j = 0;j < m;j++) {
                int down = Integer.MAX_VALUE, downLeft = Integer.MAX_VALUE, downRight = Integer.MAX_VALUE;

                down = matrix[i][j] + dp[j];
                if(j > 0) downLeft = matrix[i][j] + dp[j - 1];
                if(j < m - 1) downRight = matrix[i][j] + dp[j + 1];

                cur[j] = Math.min(down, Math.min(downLeft, downRight));
            }

            dp = cur;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i < m;i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}

class Scratch {
    public static void main(String[] args) {

    }
}