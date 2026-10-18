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
        if(length >= (index + 1)) pick = price[index] + memoization(index, price, length - (index + 1), dp);
        int notPick = memoization(index - 1, price, length, dp);

        return dp[index][length] = Math.max(pick, notPick);
    }

    int tabulation(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        for(int i = 0;i < n;i++) dp[i][0] = 0;
        for(int length = 0;length <= n;length++) dp[0][length] = length * price[0];

        for(int index = 1; index < n;index++) {
            for(int length = 0;length <= n;length++) {
                int pick = 0;
                if(length >= (index + 1)) pick = price[index] + dp[index][length - (index + 1)];
                int notPick = dp[index - 1][length];

                dp[index][length] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][n];
    }

    int spaceOptimization(int[] price) {
        int n = price.length;
        int[] prev = new int[n + 1];
        for(int length = 0;length <= n;length++) prev[length] = length * price[0];

        for(int index = 1; index < n;index++) {
            int[] cur = new int[n + 1];
            for(int length = 0;length <= n;length++) cur[length] = length * price[0];
            for(int length = 0;length <= n;length++) {
                int pick = 0;
                if(length >= (index + 1)) pick = price[index] + cur[length - (index + 1)];
                int notPick = prev[length];

                cur[length] = Math.max(pick, notPick);
            }
            prev = cur;
        }

        return dp[n - 1][n];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}