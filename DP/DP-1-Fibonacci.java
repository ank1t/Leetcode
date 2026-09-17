import java.util.*;

class Solution {
    /*
        Start with the original problem -> break it into smaller problems
        find solution for each sub problem
        join the solution to eventually find the solution for the original problem
     */
    int topDown(int n, int[] dp) {
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = topDown(n - 1, dp) + topDown(n - 2, dp);
    }

    /*
        Start with the base cases
        gradually build solution until a solution to the original problem is found
     */
    int bottomUp(int n, int[] dp) {
        for(int i = 2;i <= n;i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /*
        Only the solution to the last sub problem matters.
        We can discard the solution to the earlier sub problems.
     */
    int fibo(int n) {
        int prev1 = 1;
        int prev2 = 0;

        for(int i = 2;i <= n;i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] dp = new int[6];
        System.out.println(sol.topDown(5, dp));

        dp = new int[6];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(sol.bottomUp(5, dp));

        System.out.println(sol.fibo(5));
    }
}