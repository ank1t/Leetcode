import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {

    }

    int recursion(String s, String t, int i, int j) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        int pick = 0;
        if(s.charAt(i) == t.charAt(j))
            pick = recursion(s, t, i + 1, j + 1);
        int notPick = recursion(s, t, i + 1, j);
        return pick + notPick;
    }

    /*
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, -1);
     */
    int memoization(String s, String t, int i, int j, int[][] dp) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int pick = 0;
        if(s.charAt(i) == t.charAt(j)) {
            pick = memoization(s, t, i + 1, j + 1, dp);
        }
        int notPick = memoization(s, t, i + 1, j, dp);
        return dp[i][j] = pick + notPick;
    }

    int tabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                int pick = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    pick = dp[i - 1][j - 1];
                }
                int notPick = dp[i - 1][j];
                dp[i][j] = pick + notPick;
            }
        }
        return dp[n][m];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}