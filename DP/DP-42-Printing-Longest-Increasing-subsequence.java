import java.util.*;

class Solution {
    int printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] tracker = new int[n];
        int lastIndex = -1;

        Arrays.fill(dp, 1);
        Arrays.fill(tracker, -1);
        int maxLen = 1;

        for(int i = 1;i < n;i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && dp[i] < 1 + dp[prev]) {
                    dp[i] = 1 + dp[prev];
                    tracker[i] = prev;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        while(lastIndex != -1) {
            System.out.print(nums[lastIndex]);
            System.out.print(" ");
            lastIndex = tracker[lastIndex];
        }
        return maxLen;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.printLIS(new int[] {5,4,11,1,15,8}));;
    }
}