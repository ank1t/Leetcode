import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return f(row, col, triangle, n);
    }
    //Triangle of size 4 will have 4 elements in the last list

    //Raw recursion
    int f1(int row, int col, List<List<Integer>> triangle, int n) {
        if(row == n - 1 && col < n) return triangle.get(row).get(col);
        else if(row >= n || col >= row + 1) return Integer.MAX_VALUE;

        int up = triangle.get(row).get(col) + f(row + 1, col, triangle, n, dp);
        int upLeft = triangle.get(row).get(col) + f(row + 1, col + 1, triangle, n, dp);

        return  Math.min(up, upLeft);
    }

    /*
        Raw recursion + memoization
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, 10001);
        }
     */
    int f2(int row, int col, List<List<Integer>> triangle, int n, int[][] dp) {
        if(row == n - 1 && col < n) return triangle.get(row).get(col);

        if(dp[row][col] != 10001) return dp[row][col];

        int cur = triangle.get(row).get(col);
        int up = cur + f(row + 1, col, triangle, n, dp);
        int upLeft = cur + f(row + 1, col + 1, triangle, n, dp);

        return  dp[row][col] = Math.min(up, upLeft);
    }

    //Tabulation
    int f3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        prev[0] = triangle.get(0).get(0);
        Arrays.fill(prev, Integer.MAX_VALUE);

        for(int i = 1;i < n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < i;j++) {
                int down = triangle.get(i).get(j) + prev[i - 1];
                int downRight = triangle.get(i).get(j + 1) + prev[i - 1];

                min = Math.min(min, Math.min(down, downRight));
            }
            prev[i] = min;
        }
        return prev[n - 1];
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println();
    }
}