import java.util.*;

//https://www.geeksforgeeks.org/problems/geek-jump/1
class Solution {
    //Top Down
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        for(int i = 0;i < n;i++) dp[i] = -1;
        return jump(height, dp, n - 1);

    }

    int jump(int[] height, int[] dp, int index) {
        if(index == 0) return 0;
        if(dp[index] != -1) return dp[index];

        int left = jump(height, dp, index - 1) + Math.abs(height[index] - height[index - 1]);
        int right = Integer.MAX_VALUE;
        if(index > 1) {
            right = jump(height, dp, index - 2) + Math.abs(height[index] - height[index - 2]);
        }

        return dp[index] = Math.min(left, right);
    }

    //Bottom Up
    int minCostBU(int[] height) {
        int n = height.length;
        int[] dp = new int[n];

        for(int i = 1;i < n;i++) {
            int step1 = dp[i - 1] + Math.abs(height[i] - height[i-1]);
            int step2 = Integer.MAX_VALUE;
            if(i > 1) {
                step2 = dp[i - 2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(step1, step2);
        }
        return dp[n - 1];

    }

    //Space Optimization
    int minCostSO(int[] height) {
        int n = height.length;
        int prev1 = 0;
        int prev2 = 0;

        for(int i = 1;i < n;i++) {
            int step1 = prev1 + Math.abs(height[i] - height[i-1]);
            int step2 = Integer.MAX_VALUE;
            if(i > 1) {
                step2 = prev2 + Math.abs(height[i] - height[i-2]);
            }
            prev2 = prev1;
            prev1 = Math.min(step1, step2);
        }
        return prev1;

    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}