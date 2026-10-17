import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums) sum += num;

        if(Math.abs(target) > sum) return 0;
        return recursion(nums, 0, target);
    }

    int recursion(int[] nums, int index, int target) {
        if(index == nums.length) {
            if(target == 0) return 1;
            return 0;
        }

        int pos = 0;
        if(nums[index] <= target) pos = recursion(nums, index + 1, target - nums[index]);
        int neg = recursion(nums, index + 1, target);

        return pos + neg;
    }

    /*
        int total = 0;
        for(int num: nums) total += num;
        if((total - target) % 2 == 1 || total - target < 0) return 0;
        target = (total - target)/2;
        int[][] dp = new int[nums.length][target + 1];

        for(int[] row: dp) Arrays.fill(row, -1);
        return recursion(nums, 0, target, dp);
     */
    int memoization(int[] nums, int index, int target,int[][] dp) {
        if(index == nums.length) {
            if(target == 0) return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int pos = 0;
        if(nums[index] <= target) pos = recursion(nums, index + 1, target - nums[index], dp);
        int neg = recursion(nums, index + 1, target, dp);

        return dp[index][target] = pos + neg;
    }

    int tabulation(int[] nums, int T) {
        int n = nums.length;
        int[][] tab = new int[n][target + 1];
        for(int i = 0;i < n;i++) tab[i][0] = 0;
        if(nums[0] <= T) tab[0][nums[0]] = 1;

        for(int index = 1;index < n;index++) {
            for(int target = 1;target <= T;target++) {
                int pos = 0;
                if(nums[index] <= target) pos = tab[index + 1][target];
                int neg = tab[index + 1][target];
                tab[index][target] = pos + neg;
            }
        }
        return tab[n - 1][target];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}