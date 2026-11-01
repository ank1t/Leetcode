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
}

class Scratch {
    public static void main(String[] args) {
        
    }
}