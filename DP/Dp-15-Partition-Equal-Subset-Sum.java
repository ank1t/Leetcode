import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i < nums.length;i++) sum += nums[i];
        if(sum % 2 == 1) return false;

        return rawRecursion(nums, sum /2, 0);
    }

    boolean rawRecursion1(int[] nums, int target, int index) {
        if(target == 0) return true;
        if(index == nums.length - 1) return nums[index] == target;

        boolean pick = false;
        if(target >= nums[index]) {
            pick = rawRecursion1(nums, target - nums[index], index + 1);
        }
        boolean notPick = rawRecursion1(nums, target, index + 1);

        return pick || notPick;
    }

    boolean memoization(int[] nums, int[][] dp, int target, int index) {
        if(target == 0) return true;
        else if(index == nums.length - 1) return target == nums[index];

        if(dp[index][target] != -1) return dp[index][target] == 1;

        boolean pick = false;
        if(target >= nums[index]) {
            pick = memoization(nums, dp, target - nums[index], index + 1);
        }
        boolean notPick = memoization(nums, dp, target - nums[index], index + 1);
        boolean result = pick || notPick;
        dp[index][target] = result ? 1 : 0;

        return result;
    }

    boolean tabulation(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][Math.max(k + 1, 101)];
        for(int i = 0;i < n;i++) dp[i][0] = true;
        dp[0][nums[0]] = true;

        for(int index = 1;index < n;index++) {
            for(int target = 1;target <= k;target++) {
                boolean pick = false;
                if(target >= nums[index]) {
                    pick = dp[index - 1][target - nums[index]];
                }
                boolean notPick = dp[index - 1][target];
                dp[index][target] = pick || notPick;
            }
        }
        return dp[n - 1][k];
    }

    boolean spaceOptimization(int[] nums, int k) {
        int n = nums.length;
        boolean[] prev = new boolean[Math.max(101, k + 1)];
        boolean[] cur = new boolean[Math.max(101, k + 1)];
        prev[0] = true;
        cur[0] = true;
        prev[nums[0]] = true;

        for(int index = 1;index < n;index++) {
            for(int target = 1;target <= k;target++) {
                boolean pick = false;
                if(target >= nums[index]) {
                    pick = prev[target - nums[index]];
                }
                boolean notPick = prev[target];
                cur[target] = pick || notPick;
            }
            prev = cur;
        }
        return prev[k];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}