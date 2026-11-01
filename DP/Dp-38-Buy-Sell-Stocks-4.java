import java.util.*;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] next = new int[2 * k + 1];

        for (int index = n - 1; index >= 0; index--) {
            int[] cur = new int[2 * k + 1];
            for (int txCount = 0; txCount < k * 2; txCount++) {
                if (txCount % 2 == 0) {
                    int buy = -prices[index] + next[txCount + 1];
                    int notBuy = next[txCount];
                    cur[txCount] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + next[txCount + 1];
                    int notSell = next[txCount];
                    cur[txCount] = Math.max(sell, notSell);
                }
            }
            next = cur;
        }
        return next[0];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}