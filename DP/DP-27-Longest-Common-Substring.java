import java.util.*;

class Solution {
    public int longCommSubstr(String s1, String s2) {
        return tabulation(s1, s2);
    }

    int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        int maxLen = 0;

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i > 0 && j > 0) {
                        /*
                            update dp at i and j and then update maxLen if needed.
                            If maxLen is updated before, dp[i][j] will have incorrect value
                         */
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else dp[i][j] = 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}