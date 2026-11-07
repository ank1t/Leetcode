import java.util.*;

class Solution {

    int recursion(int[] nums, int i, int j) {
        if(i == j) return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i;k < j;k++) {
            int cost = solve(nums, i, k) + solve(nums, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
        }
        return min;
    }

    int memoization(int[] nums, int i, int j) {
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k < j;k++) {
            int cost = solve(nums, i, k) + solve(nums, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}