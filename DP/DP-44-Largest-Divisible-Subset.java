import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n == 1) return List.of(nums[0]);
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];
        int maxLen = 0;
        int lastIndex = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        for(int i = 1;i < n;i++) {
            for(int prev = 0;prev < i;prev++) {
                if(dp[i] % dp[prev] == 0 && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    parent[i] = prev;
                }
            }

            if(maxLen < dp[i]) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        while(lastIndex != -1) {
            ans.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        return ans;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}