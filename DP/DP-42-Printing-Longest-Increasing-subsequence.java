import java.util.*;

class Solution {
    int printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for(int i = 1;i < n;i++) {
            for(int prev = 0;prev < i;prev++) {
                if(nums[i] > nums[prev]) {
                    dp[i] = Math.max(dp[i],  1 + dp[prev]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.printLIS(new int[]{5,4,11,1,15,8}));;
    }
}