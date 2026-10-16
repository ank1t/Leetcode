import java.util.*;

/*
    https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
 */
class Solution {
    int perfectSum(int[] arr, int target) {
        // code here

    }

    int recursion(int[] arr, int index, int target) {
        if(index == arr.length) return target == 0 ? 1 : 0;

        int pick = 0;
        if(arr[index] <= target) pick = recursion(arr, index + 1, target - arr[index]);
        int notPick = recursion(arr, index + 1, target);

        return pick + notPick;
    }

    int memoization(int[] arr, int[][] dp, int index, int target) {
        if(index == arr.length) {
            if(target == 0) return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int pick = 0;
        if(arr[index] <= target) pick = memoization(arr, dp, index + 1, target - arr[index]);
        int notPick = memoization(arr, dp, index + 1, target);

        return dp[index][target] = pick + notPick;
    }

    int tabulation(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        if (arr[0] <= k)
            dp[0][arr[0]] = dp[0][arr[0]] != 0 ? dp[0][arr[0]] + 1 : 1;

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= k; target++) {
                int pick = 0;
                if (arr[index] <= target)
                    pick = dp[index - 1][target - arr[index]];
                int notPick = dp[index - 1][target];
                dp[index][target] = pick + notPick;
            }
        }
        return dp[n - 1][k];
    }

    int spaceOptimization(int[] arr, int k) {
        int n = arr.length;
        int[] prev = new int[k + 1];
        prev[0] = 1;
        if (arr[0] <= k)
            prev[arr[0]] = prev[arr[0]] != 0 ? prev[arr[0]] + 1 : 1;

        for (int index = 1; index < n; index++) {
            int[] cur = new int[k + 1];
            for (int target = 0; target <= k; target++) {
                int pick = 0;
                if (arr[index] <= target)
                    pick = prev[target - arr[index]];
                int notPick = prev[target];
                cur[target] = pick + notPick;
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