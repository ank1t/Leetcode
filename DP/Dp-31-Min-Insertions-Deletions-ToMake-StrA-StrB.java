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
}

class Scratch {
    public static void main(String[] args) {
        
    }
}