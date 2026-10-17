import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = recursion(coins, 0, amount, dp);
        return result > 100000 ? -1 : result;
    }

    int recursion(int[] coins, int index, int amount) {
        if(index == coins.length) {
            return amount > 0 ? 1_000_000_000 : 0;
        }

        int pick = Integer.MAX_VALUE;
        if(coins[index] <= amount) pick = 1 + recursion(coins, index, amount - coins[index], dp);
        int notPick = recursion(coins, index + 1, amount, dp);

        return Math.min(pick, notPick);
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}