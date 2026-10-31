import java.util.*;

class Solution {
    //O(n)
    //Space optimization usually expected in DP on stocks
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] maxArray = new int[prices.length];
        int maxElementSoFar = -1;

        for(int i = prices.length - 1;i >= 0;i--) {
            maxElementSoFar = Math.max(prices[i], maxElementSoFar);
            maxArray[i] = maxElementSoFar;
        }

        for(int i = 0;i < prices.length;i++) {
            maxProfit = Math.max(maxArray[i] - prices[i], maxProfit);
        }
        return maxProfit;
    }

    /*
        We only sell a stock after we buy it.
        So moving from left to right, keep track of the min price of the stock
        for every element, check if selling increases the profit.
     */

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minElement = prices[0];

        for(int i = 1;i < prices.length;i++) {
            minElement = Math.min(minElement, prices[i]);
            maxProfit = Math.max(prices[i] - minElement, maxProfit);
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        int minElement = prices[0];

        for(int i = 1;i < prices.length;i++) {
            maxProfit = Math.max(prices[i] - minElement, maxProfit);
            minElement = Math.min(minElement, prices[i]);
        }
        return maxProfit;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}