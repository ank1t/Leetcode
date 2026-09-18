import java.util.*;

/*
    Also called Stickler thief problem - loot houses but cannot loot adjacent houses.
    Maximize loot
 */
class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        return dp(n - 1, arr);
    }

    private int dp(int index, int[] arr) {
        if(index == 0) return arr[0];
        if(index < 0) return 0;

        int pick = arr[index] + dp(index - 2, arr);
        int notpick = dp(index - 1, arr);

        return Math.max(pick, notpick);
    }

    // Memoized solution - Top down
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0;i < n;i++) dp[i] = -1;
        return maxSum(n - 1, arr, dp);
    }

    private int maxSum(int index, int[] arr, int[] dp) {
        if(index == 0) return arr[0];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];

        int pick = arr[index] + maxSum(index - 2, arr, dp);
        int notpick = maxSum(index - 1, arr, dp);

        return dp[index] = Math.max(pick, notpick);
    }

    //Bottom up
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        return maxSum(arr, n);
    }

    private int maxSum(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2;i < arr.length;i++) {
            int pick = dp[i - 2] + arr[i];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    //Space Optimization
    public int findMaxSum(int arr[]) {
        return maxSum(arr);
    }

    private int maxSum(int[] arr) {
        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);
        for(int i = 2;i < arr.length;i++) {
            int pick = prev2 + arr[i];
            int notPick = prev1;
            int cur = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxSum());
    }
}