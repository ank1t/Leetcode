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

    int memoization(int index1, int index2, String s1, String s2, int[][] dp) {
        if(index1 < 0 || index2 < 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2))
            return dp[index1][index2] = 1 + memoization(index1 - 1, index2 - 1, s1, s2, dp);

        return dp[index1][index2] = Math.max(memoization(index1 - 1, index2, s1, s2, dp),
                memoization(index1, index2 - 1, s1, s2, dp));
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}