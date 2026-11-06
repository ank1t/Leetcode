import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        int[] dp = new int[n];
        int[] freq = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(freq, 1);
        int countOfLIS = 0;
        int lisLength = 0;

        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    //important line
                    freq[i] = freq[j];
                } else if(nums[i] > nums[j] && dp[i] == 1 + dp[j]) {
                    freq[i] += freq[j];
                }
            }
            lisLength = Math.max(dp[i], lisLength);
        }

        for(int i = 0;i < n;i++) {
            if(lisLength == dp[i]) countOfLIS += freq[i];
        }
        return countOfLIS;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}