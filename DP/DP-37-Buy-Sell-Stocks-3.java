import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {

    }

    int recursion(int[] prices, int index, int canBuy, int txCount) {
        if(txCount >= 2) return 0;
        if(index == prices.length) return 0;

        if(canBuy == 1) {
            int buy = -prices[index] + recursion(prices, index + 1, 0, txCount);
            int notBuy = recursion(prices, index + 1, 1, txCount);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + recursion(prices, index + 1, 1, txCount + 1);
            int notSell = recursion(prices, index + 1, 0, txCount);
            return Math.max(sell, notSell);
        }
    }

    int memoization(int[] prices, int index, int canBuy, int txCount, int[][][] dp) {
        if(txCount >= 2) return 0;
        if(index == prices.length) return 0;

        if(dp[index][canBuy][txCount] != -1) return dp[index][canBuy][txCount];
        if(canBuy == 1) {
            int buy = -prices[index] + memoization(prices, index + 1, 0, txCount, dp);
            int notBuy = memoization(prices, index + 1, canBuy, txCount, dp);
            return dp[index][canBuy][txCount] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + memoization(prices, index + 1, 1, txCount + 1, dp);
            int notSell = memoization(prices, index + 1, canBuy, txCount, dp);
            return dp[index][canBuy][txCount] = Math.max(sell, notSell);
        }
    }

    int tabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                for (int txCount = 0; txCount < 2; txCount++) {
                    if (canBuy == 1) {
                        int buy = -prices[index] + dp[index + 1][0][txCount];
                        int notBuy = dp[index + 1][canBuy][txCount];
                        dp[index][canBuy][txCount] = Math.max(buy, notBuy);
                    } else {
                        int sell = prices[index] + dp[index + 1][1][txCount + 1];
                        int notSell = dp[index + 1][canBuy][txCount];
                        dp[index][canBuy][txCount] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][0];
    }

    /*
           for (int index = n - 1; index >= 0; index--) {
                for (int canBuy = 0; canBuy < 2; canBuy++) {
                    for (int txCount = 1; txCount >= 0; txCount--) {
                    }
                }
           }

           for (int index = n - 1; index >= 0; index--) {
                for (int canBuy = 1; canBuy >= 0; canBuy--) {
                    for (int txCount = 0; txCount < 2; txCount++) {
                    }
                }
           }

           Works too
     */
    int spaceOptimization(int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {
            int[][] cur = new int[2][3];
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                for (int txCount = 0; txCount < 2; txCount++) {
                    if (canBuy == 1) {
                        int buy = -prices[index] + prev[0][txCount];
                        int notBuy = prev[canBuy][txCount];
                        cur[canBuy][txCount] = Math.max(buy, notBuy);
                    } else {
                        int sell = prices[index] + prev[1][txCount + 1];
                        int notSell = prev[canBuy][txCount];
                        cur[canBuy][txCount] = Math.max(sell, notSell);
                    }
                }
            }
            prev = cur;
        }
        return prev[1][0];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}