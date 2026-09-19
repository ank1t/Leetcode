import java.util.*;

class Solution {
    int minCostBU(int[] height, int k) {
        int n = height.length;
        int[] dp = new int[n];

        for(int i = 1;i < n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1;j <= k;j++) {
                if (i - j >= 0) {
                    min = Math.min(min, dp[i - j] + Math.abs(height[i] - height[i - j]));
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];

    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println();
    }
}