import java.util.*;

class Solution {
    /*
    Plain recursive solution - Using Top down approach
    TC - 2 ^ (m * n)
    SC - O(path length) (m - 1) + (n - 1)
     */
    int f1(int i, int j) {
        if(i == 0 && j == 0) return 1;
        else if(i < 0 || j < 0) return 0;

        int up = f1(i - 1, j);
        int left = f1(i, j - 1);

        return up + left;
    }

    //Plain recursive solution using bottom up
    int f2(int i, int j, int m, int n) {
        if(i == m - 1 && j == n - 1) return 1;
        else if(i < 0 || j < 0) return 0;

        int down = f2(i + 1, j, m, n);
        int right = f2(i, j + 1, m ,n);

        return down + right;
    }

    //Tabulation
    int f3(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up, left = 0;
                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //Space optimization

}

class Scratch {
    public static void main(String[] args) {
        
    }
}