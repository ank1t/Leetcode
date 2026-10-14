import java.util.*;

/*
    https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1

 */
class Solution {
    //Memoized approach
    public boolean checkSubsequenceSum(int[] arr, int k) {
        if(k == 0) return true;
        if(arr.length == 1) return arr[0] == k;

        int[][] dp = new int[arr.length][k + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return f(0, k, arr, dp);
    }

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
}

class Scratch {
    public static void main(String[] args) {
        
    }
}