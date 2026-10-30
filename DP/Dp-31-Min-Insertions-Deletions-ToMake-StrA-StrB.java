import java.util.*;

class Solution {
    /*
        ABCD -> ANC
     */
    int transform(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp)  Arrays.fill(row, -1);

        int lcs = memoization(s1, s2, n - 1, m - 1, dp);
        return n + m - 2 * lcs;
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

    int tabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1;i <= n;i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

    int spaceOptimization(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];

        for(int i = 1;i <= n;i++) {
            int[] cur = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    cur[j] = 1 + prev[j - 1];
                else cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            prev = cur;
        }

        return prev[m];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}