class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return recursion(word1, word2, n - 1, m - 1);
    }

    int recursion(String s, String t, int i, int j) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(s.charAt(i) == t.charAt(j)) return recursion(s, t, i - 1, j - 1);
        else {
            int replace = 1 + recursion(s, t, i - 1, j - 1);
            int insert = 1 + recursion(s, t, i, j - 1);
            int delete = 1 + recursion(s, t, i - 1, j);

            return Math.min(Math.min(replace, insert), delete);
        }
    }

    int memoization(String s, String t, int i, int j, int[][] dp) {
        if(i <= 0) return j + 1;
        if(j <= 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = memoization(s, t, i - 1, j - 1, dp);
        else {
            int replace = 1 + memoization(s, t, i - 1, j - 1, dp);
            int insert = 1 + memoization(s, t, i, j - 1, dp);
            int delete = 1 + memoization(s, t, i - 1, j, dp);

            return dp[i][j] = Math.min(Math.min(replace, insert), delete);
        }
    }

    int tabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0;i <= n;i++) dp[i][0] = i;
        for(int i = 0;i <= m;i++) dp[0][i] = i;
        dp[0][0] = 0;

        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int replace = 1 + dp[i - 1][j - 1];
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];

                    dp[i][j] = Math.min(Math.min(replace, insert), delete);
                }
            }
        }
        return dp[n][m];
    }

    int spaceOptimization(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];

        for(int i = 0;i <= m;i++) prev[i] = i;

        for(int i = 1;i <= n;i++) {
            int[] cur = new int[m + 1];
            cur[0] = i;
            for(int j = 1;j <= m;j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) cur[j] = prev[j - 1];
                else {
                    int replace = 1 + prev[j - 1];
                    int insert = 1 + cur[j - 1];
                    int delete = 1 + prev[j];

                    cur[j] = Math.min(Math.min(replace, insert), delete);
                }
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