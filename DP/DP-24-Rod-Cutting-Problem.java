//https://www.geeksforgeeks.org/problems/rod-cutting0840/1
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;

        return recursion(n - 1, price, n);
    }

    int recursion(int index, int[] price, int length) {
        if(length == 0) return 0;
        if(index == 0) {
            return length * price[0];
        }

        int pick = 0;
        if(length >= (index + 1)) pick = price[index] + recursion(index, price, length - (index + 1));
        int notPick = recursion(index - 1, price, length);

        return Math.max(pick, notPick);
    }

    int memoization(int index, int[] price, int length, int[][] dp) {
        if(length == 0) return 0;
        if(index == 0) {
            return length * price[0];
        }

        if(dp[index][length] != -1) return dp[index][length];

        int pick = 0;
        if(length >= (index + 1)) pick = price[index] + recursion(index, price, length - (index + 1), dp);
        int notPick = recursion(index - 1, price, length, dp);

        return dp[index][length] = Math.max(pick, notPick);
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}