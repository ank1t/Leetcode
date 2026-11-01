import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {

    }

    int recursion(int[] prices, int index, int bIndex) {
        if(index == prices.length - 1) {
            if(bIndex == -1) return 0;
            return prices[index] - prices[bIndex];
        }

        if(bIndex == -1) {
            int buy = recursion(prices, index + 1, index);
            int notBuy = recursion(prices, index + 1, bIndex);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] - prices[bIndex] + recursion(prices, index + 1, -1);
            int notSell = recursion(prices, index + 1, bIndex);

            return Math.max(sell, notSell);
        }
    }

    //Optimized recursion
    /*
        Time complexity 2 ^ n
        Space complexity O(n)
     */
    int recursion(int[] prices, int index, boolean canBuy) {
        if(index == prices.length) {
            return 0;
        }

        if(canBuy) {
            int buy = -prices[index] + recursion(prices, index + 1, false);
            int notBuy = recursion(prices, index + 1, canBuy);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + recursion(prices, index + 1, true);
            int notSell = recursion(prices, index + 1, canBuy);

            return Math.max(sell, notSell);
        }
    }

    int memoization(int[] prices, int index, int canBuy, int[][] dp) {
        if(index == prices.length) {
            return 0;
        }

        if(dp[index][canBuy] != -1) return dp[index][canBuy];

        if(canBuy == 1) {
            int buy = -prices[index] + memoization(prices, index + 1, 0, dp);
            int notBuy = memoization(prices, index + 1, canBuy, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + memoization(prices, index + 1, 1, dp);
            int notSell = memoization(prices, index + 1, canBuy, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }

    int tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                if (canBuy == 1) {
                    int buy = -prices[index] + dp[index + 1][0];
                    int notBuy = dp[index + 1][canBuy];
                    dp[index][canBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + dp[index + 1][1];
                    int notSell = dp[index + 1][canBuy];
                    dp[index][canBuy] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }

    int spaceOptimization(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];

        for (int index = n - 1; index >= 0; index--) {
            int[] cur = new int[2];
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                if (canBuy == 1) {
                    int buy = -prices[index] + prev[0];
                    int notBuy = prev[canBuy];
                    cur[canBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + prev[1];
                    int notSell = prev[canBuy];
                    cur[canBuy] = Math.max(sell, notSell);
                }
            }
            prev = cur;
        }
        return prev[1];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}