import java.util.*;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        return recursion(prices, 0, 1);
    }

    int recursion(int[] prices, int index, int canBuy, int fee) {
        if(index == prices.length) return 0;

        if(canBuy == 1) {
            int buy = -prices[index] + recursion(prices, index + 1, 0, fee);
            int notBuy = recursion(prices, index + 1, 1, fee);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] - fee + recursion(prices, index + 1, 1, fee);
            int notSell = recursion(prices, index + 1, 0, fee);
            return Math.max(sell, notSell);
        }
    }

    int memoization(int[] prices, int index, int canBuy, int fee, int[][] dp) {
        if(index == prices.length) return 0;

        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        if(canBuy == 1) {
            int buy = -prices[index] + memoization(prices, index + 1, 0, fee, dp);
            int notBuy = memoization(prices, index + 1, 1, fee, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] - fee + memoization(prices, index + 1, 1, fee, dp);
            int notSell = memoization(prices, index + 1, 0, fee, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }

    int tabulation(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    int buy = -prices[index] + dp[index + 1][0];
                    int notBuy = dp[index + 1][1];
                    dp[index][canBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] - fee + dp[index + 1][1];
                    int notSell = dp[index + 1][0];
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