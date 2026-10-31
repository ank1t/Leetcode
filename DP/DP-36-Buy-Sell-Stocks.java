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
}

class Scratch {
    public static void main(String[] args) {
        
    }
}