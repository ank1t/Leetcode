import java.util.*;

class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        if (n == 1)
            return 0;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp1[i] < 1 + dp1[j]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && dp2[i] < 1 + dp2[j]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if(dp1[i] > 1 && dp2[i] > 1) {
                maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
            }
        }
        return maxLen;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}