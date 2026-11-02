import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {

    }

    int recursion(int[] nums, int index, int sIndex) {
        if (index == nums.length) return 0;

        int pick = 0;
        if (sIndex == -1 || nums[index] > nums[sIndex]) {
            pick = 1 + recursion(nums, index + 1, index);
        }
        int notPick = recursion(nums, index + 1, sIndex);
        return Math.max(pick, notPick);
    }

    int memoization(int[] nums, int index, int sIndex, int [][] dp) {
        if (index == nums.length) return 0;

        if(dp[index][sIndex + 1] == -1) return dp[index][sIndex + 1];

        int pick = 0;
        if (sIndex == -1 || nums[index] > nums[sIndex]) {
            pick = 1 + memoization(nums, index + 1, index, dp);
        }
        int notPick = memoization(nums, index + 1, sIndex, dp);
        return dp[index][sIndex + 1] = Math.max(pick, notPick);
    }

    int tabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int sIndex = index - 1; sIndex >= -1; sIndex--) {
                int pick = 0;
                if (sIndex == -1 || nums[index] > nums[sIndex]) {
                    pick = 1 + dp[index + 1][index + 1];
                }
                int notPick = dp[index + 1][sIndex + 1];
                dp[index][sIndex + 1] = Math.max(pick, notPick);
            }
        }
        return dp[0][-1 + 1];
    }

    int spaceOptimization(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            int[] cur = new int[n + 1];
            for (int sIndex = index - 1; sIndex >= -1; sIndex--) {
                int pick = 0;
                if (sIndex == -1 || nums[index] > nums[sIndex]) {
                    pick = 1 + next[index + 1];
                }
                int notPick = next[sIndex + 1];
                cur[sIndex + 1] = Math.max(pick, notPick);
            }
            next = cur;
        }
        return next[-1 + 1];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}