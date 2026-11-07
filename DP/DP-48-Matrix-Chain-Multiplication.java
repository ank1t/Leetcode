import java.util.*;

class Solution {

    int recursion(int[] nums, int i, int j) {
        if(i == j) return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i;k < j;k++) {
            int cost = solve(nums, i, k) + solve(nums, k + 1, j) + nums[i - 1] * nums[k] * nums[j];
            min = Math.min(min, cost);
        }
        return min;
    }

    int memoization(int[] nums, int i, int j) {
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k < j;k++) {
            int cost = solve(nums, i, k) + solve(nums, k + 1, j) + nums[i - 1] * nums[k] * nums[j];
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    int tabulation(int[] nums) {
        int n = arr.length;
        if (n == 1)
            return 0;

        int[][] dp = new int[n][n];

        // Smart move
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 2; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}