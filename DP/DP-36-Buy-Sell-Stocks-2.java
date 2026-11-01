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
            int buy = -prices[index] + recursion(prices, index + 1, 0, dp);
            int notBuy = recursion(prices, index + 1, canBuy, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + recursion(prices, index + 1, 1, dp);
            int notSell = recursion(prices, index + 1, canBuy, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}