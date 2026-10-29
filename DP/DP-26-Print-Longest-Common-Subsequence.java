import java.util.*;

class Solution {
    void longestCommonSubsequence() {
        System.out.println(tabulation("abcde", "abdfe"));
    }

    String tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int index1 = 1;index1 <= n;index1++) {
            for(int index2 = 1;index2 <= m;index2++) {
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2];

                else dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
            }
        }

        String s = "";
        int i = n - 1, j = m - 1;
        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                s = s1.charAt(i - 1) + s;
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) i--;
              else j--;
        }
        return s;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestCommonSubsequence();
    }
}