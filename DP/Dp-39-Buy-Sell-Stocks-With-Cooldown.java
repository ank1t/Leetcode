import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {

    }

    int recursion(int[] prices, int index, int canBuy) {
        if(index >= prices.length) return 0;

        if(canBuy == 1) {
            int buy = -prices[index] + recursion(prices, index + 1, 0);
            int notBuy = recursion(prices, index + 1, canBuy);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + recursion(prices, index + 2, 1);
            int notSell = recursion(prices, index + 1, canBuy);
            return Math.max(sell, notSell);
        }
    }

    int memoization(int[] prices, int index, int canBuy, int[][] dp) {
        if(index >= prices.length) return 0;

        if (dp[index][canBuy] != -1) return dp[index][canBuy];

        if(canBuy == 1) {
            int buy = -prices[index] + memoization(prices, index + 1, 0, dp);
            int notBuy = memoization(prices, index + 1, canBuy, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + memoization(prices, index + 2, 1, dp);
            int notSell = memoization(prices, index + 1, canBuy, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }

    int tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                if (canBuy == 1) {
                    int buy = -prices[index] + dp[index + 1][0];
                    int notBuy = dp[index + 1][canBuy];
                    dp[index][canBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + dp[index + 2][1];
                    int notSell = dp[index + 1][canBuy];
                    dp[index][canBuy] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][1];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}