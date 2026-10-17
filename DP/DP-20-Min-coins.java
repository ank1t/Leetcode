import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = recursion(coins, 0, amount, dp);
        return result > 100000 ? -1 : result;
    }

    int recursion(int[] coins, int index, int amount) {
        if(index == coins.length) {
            return amount > 0 ? 1_000_000_000 : 0;
        }

        int pick = Integer.MAX_VALUE;
        if(coins[index] <= amount) pick = 1 + recursion(coins, index, amount - coins[index], dp);
        int notPick = recursion(coins, index + 1, amount, dp);

        return Math.min(pick, notPick);
    }

    /*
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        int result = recursion(coins, 0, amount, dp);
        return result > 100000 ? -1 : result;
     */
    int memoization(int[] coins, int index, int amount, int[][] dp) {
        if(index == coins.length) {
            return amount > 0 ? 1_000_000_000 : 0;
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int pick = Integer.MAX_VALUE;
        //Infinite supply or multiple use of some thing, on take we dont increase the index.
        if(coins[index] <= amount) pick = 1 + memoization(coins, index, amount - coins[index], dp);
        int notPick = memoization(coins, index + 1, amount, dp);

        return dp[index][amount] = Math.min(pick, notPick);
    }

    int tabulation(int[] coins, int A) {
        int n = coins.length;
        int[][] tab = new int[n][A + 1];
        for(int[] row: tab) {
            Arrays.fill(row, 1_000_000_000);
            row[0] = 0;
        }

        for(int amount = 1;amount <= A;amount++ ) {
            if(amount % coins[0] == 0) tab[0][amount] = amount/coins[0];
        }
        for(int index = 1;index < n;index++) {
            for(int amount = 1;amount <= A;amount++) {
                int pick = Integer.MAX_VALUE;
                if(coins[index] <= amount) pick = 1 + tab[index][amount - coins[index]];
                int notPick = tab[index - 1][amount];

                tab[index][amount] = Math.min(pick, notPick);
            }
        }

        return tab[n - 1][A];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}