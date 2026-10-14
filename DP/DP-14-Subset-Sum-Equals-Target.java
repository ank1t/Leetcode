import java.util.*;

/*
    https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1

 */
class Solution {
    //Memoized approach
    public boolean checkSubsequenceSum(int[] arr, int k) {
        if(arr.length == 1) return arr[0] == k;

        int[][] dp = new int[arr.length][k + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return f(0, k, arr, dp);
    }

    /*
        Raw Recursion
        TC = O(2 ^ n)
        SC = O(n)

        Memoized approach
        TC = O(n * target)
        SC = O(n * target) + O(n)
     */
    boolean f(int index, int target, int[] arr, int[][] dp) {
        if(target == 0) return true;
        else if(index == arr.length -1) return arr[index] == target;

        if(dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean pick = false;
        if(arr[index] <= target) {
            pick = f(index + 1, target - arr[index], arr, dp);
        }
        boolean notPick = f(index + 1, target, arr, dp);
        boolean result = pick || notPick;
        dp[index][target] = result ? 1 : 0;

        return result;
    }

    boolean tabulation(int[] arr, int k) {
        int n = arr.length;
        boolean[][] dp = new boolean[2001][2001];
        for(int i = 0;i < n;i++) dp[i][0] = true;
        dp[0][arr[0]] = true;

        for(int index = 1;index < n;index++) {
            for(int target = 1;target <= k;target++) {
                boolean pick = false;
                if(arr[index] <= target) {
                    pick = dp[index - 1][target - arr[index]];
                }
                boolean notPick = dp[index - 1][target];
                boolean result = pick || notPick;
                dp[index][target] = result;
            }
        }
        return dp[n - 1][k];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}