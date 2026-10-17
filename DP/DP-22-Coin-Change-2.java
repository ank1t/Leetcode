import java.util.*;

//https://leetcode.com/problems/coin-change-ii/description/
class Solution {

    public int change(int amount, int[] coins) {

    }

    /*
        Time complexity - exponential
        space complexity - larger than O(n) and in worst case can be O(target)
     */
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
        TC -> O(N * T)
        SC -> O(N * T) + O(target)
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

    int tabulation(int[] coins, int A) {
        int n = coins.length;
        int[][] dp = new int[n][A + 1];

        for(int amount = 0;amount <= A;amount++) {
            if(amount % coins[0] == 0) dp[0][amount] = 1;
        }

        for(int index = 1;index < n;index++){
            for(int amount = 0;amount <= A;amount++) {
                int pick = 0;
                if(coins[index] <= amount) pick = dp[index][amount - coins[index]];
                int notPick = dp[index - 1][amount];

                dp[index][amount] = pick + notPick;
            }
        }

        return dp[n - 1][A];
    }

    int spaceOptimization(int[] coins, int A) {
        int n = coins.length;
        int[] prev = new int[A + 1];

        for(int amount = 0;amount <= A;amount++) {
            if(amount % coins[0] == 0) prev[amount] = 1;
        }

        for(int index = 1;index < n;index++){
            int[] cur = new int[A + 1];
            for(int amount = 0;amount <= A;amount++) {
                int pick = 0;
                if(coins[index] <= amount) pick = cur[amount - coins[index]];
                int notPick = prev[amount];

                cur[amount] = pick + notPick;
            }
            prev = cur;
        }

        return prev[A];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}