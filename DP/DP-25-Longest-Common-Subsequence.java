import java.util.*;

/*
    https://leetcode.com/problems/longest-common-subsequence/description/

    Common patterns of problems - Comparisons, replace or edits
    For a string of length n - number of subsequences is 2^n
    Brute force will be exponential -> Generate all the subsequences and compare.
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return recursion(n - 1, m - 1, text1, text2);
    }

    /*
        TC -> 2^n * 2^m
     */
    int recursion(int index1, int index2, String s1, String s2) {
        if(index1 < 0 || index2 < 0) return 0;

        if(s1.charAt(index1) == s2.charAt(index2))
            return 1 + recursion(index1 - 1, index2 - 1, s1, s2);

        return Math.max(recursion(index1 - 1, index2, s1, s2),
                recursion(index1, index2 - 1, s1, s2));
    }

    /*
        TC -> N * M
        SC -> N * M  + O(N + M)

        It takes N * M to fill DP 2D array. After that, every call returns in constant time.

        there can be a max of n deletions from s1 and m deletions from s2.
     */
    int memoization(int index1, int index2, String s1, String s2, int[][] dp) {
        if(index1 < 0 || index2 < 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2))
            return dp[index1][index2] = 1 + memoization(index1 - 1, index2 - 1, s1, s2, dp);

        return dp[index1][index2] = Math.max(memoization(index1 - 1, index2, s1, s2, dp),
                memoization(index1, index2 - 1, s1, s2, dp));
    }

    int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++)  dp[i][0] = 0;

        for(int i = 0;i < m;i++) dp[0][i] = 1;

        for(int index1 = 1;index1 <= n;index1++) {
            for(int index2 = 1;index2 < m;index2++) {
                if(s1.charAt(index1) == s2.charAt(index2))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2];

                else dp[index1][index2] = Math.max(dp[index1 - 1][index2],
                        dp[index1][index2 - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }

    int spaceOptimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        for(int i = 0;i <= m;i++) prev[i] = 0;

        for(int index1 = 1;index1 <= n;index1++) {
            int[] cur = new int[m + 1];
            for(int index2 = 1;index2 <= m;index2++) {
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    cur[index2] = 1 + prev[index2 - 1];

                else cur[index2] = Math.max(prev[index2],
                        cur[index2 - 1]);
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