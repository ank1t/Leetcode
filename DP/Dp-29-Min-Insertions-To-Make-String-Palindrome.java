import java.util.*;

class Solution {
    public int minInsertions(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();

        return n - recursion(s, t, n - 1, n - 1);
    }

    int recursion(String s, String t, int i, int j) {
        if(i < 0 || j < 0) return 0;

        if(s.charAt(i) == t.charAt(j))
            return 1 + recursion(s, t, i - 1, j - 1);
        else return Math.max(recursion(s, t, i - 1, j),
                recursion(s, t, i, j - 1));
    }

    int memoization(String s, String t, int i, int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + memoization(s, t, i - 1, j - 1, dp);
        else return dp[i][j] = Math.max(memoization(s, t, i - 1, j, dp),
                memoization(s, t, i, j - 1, dp));
    }

    int tabulation(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= n;j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j],
                        dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}