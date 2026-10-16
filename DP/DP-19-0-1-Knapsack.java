import java.util.*;

/*
    Self note : in 0/1 knapsack you can either take the item or you dont - while in fractional knapsack you can get a fraction of an item.
    Greedy will work in fractional knapsack (sort by val/weight) not on 0/1 knapsack
 */
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here

    }

    int recursion(int[] val, int[] wt, int index, int W) {
        if(index == val.length || W == 0) return 0;

        int pick = 0;
        if(wt[index] <= W) pick = val[index] + recursion(val, wt, index + 1, W - wt[index]);
        int notPick = recursion(val, wt, index + 1, W);

        return Math.max(pick, notPick);
    }

    /*
        n = val.length;
        int[][] dp = new int[n][W + 1];
     */
    int memoization(int[] val, int[] wt, int index, int W, int[][] dp) {
        if(index == val.length || W == 0) return 0;

        if(dp[index][W] != 0) return dp[index][W];

        int pick = 0;
        if(wt[index] <= W) pick = val[index] + recursion(val, wt, index + 1, W - wt[index], dp);
        int notPick = recursion(val, wt, index + 1, W, dp);

        return dp[index][W] = Math.max(pick, notPick);
    }

    int tabulation(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n][W + 1];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}