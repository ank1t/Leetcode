import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for(int num: nums) if(num > 0) sum += num;

        return tabulation(nums, sum);
    }

    int tabulation(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][k + 1];
        for(int i = 0;i < n;i++) dp[i][0] = true;
        if(nums[0] <= k) dp[0][nums[0]] = true;

        for(int index = 1;index < n;index++) {
            for(int target = 1;target <= k;target++) {
                boolean pick = false;
                if(nums[index] <= target) pick = dp[index - 1][target - nums[index]];
                boolean notPick = dp[index - 1][target];
                dp[index][target] = pick || notPick;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i <= k/2;i++) {
            if(dp[n - 1][i]) min = Math.min(min, Math.abs(i - ( k - i)));
        }
        return min;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}