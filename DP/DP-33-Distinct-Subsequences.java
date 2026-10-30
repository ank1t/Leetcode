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
        Order of base cases matter. If you first check for i<0 and return 0, it will give wrong answer.
        This is because suppose i becomes less than 0, but j also becomes less than 0, then you found a subsequence, so it should return 1.
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

        // Base Case: An empty target string (t of length 0) can always
        // be formed 1 way by deleting all characters from s.
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

    int spaceOptimization(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        prev[0] = 1;

        for(int i = 1;i <= n;i++) {
            int[] cur = new int[m + 1];
            prev[0] = 1;
            for(int j = 1;j <= m;j++) {
                int pick = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    pick = prev[j - 1];
                }
                int notPick = prev[j];
                cur[j] = pick + notPick;
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