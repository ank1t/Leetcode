import java.util.*;

//https://leetcode.com/problems/coin-change-ii/description/
class Solution {
    public int change(int amount, int[] coins) {

    }

    int recursion(int[] coins, int index, int amount) {
        if(amount == 0) return 1;
        if(index == 0) {
            if(amount % coins[0] == 0) return 1;
            return 0;
        }

        int pick = 0;
        if(coins[index] <= amount) pick = recursion(coins, index, amount - coins[index], dp);
        int notPick = recursion(coins, index - 1, amount, dp);

        return pick + notPick;
    }

    /*
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
     */
    int memoization(int[] coins, int index, int amount, int[][] dp) {
        if(amount == 0) return 1;
        if(index == 0) {
            if(amount % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[index][amount] != -1) return dp[index][amount];

        int pick = 0;
        if(coins[index] <= amount) pick = recursion(coins, index, amount - coins[index], dp);
        int notPick = recursion(coins, index - 1, amount, dp);

        return dp[index][amount] = pick + notPick;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}