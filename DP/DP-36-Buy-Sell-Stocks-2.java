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
}

class Scratch {
    public static void main(String[] args) {
        
    }
}