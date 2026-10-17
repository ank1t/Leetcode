import java.util.*;

//https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[wt.length][capacity + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return memoization(val, wt, capacity, wt.length - 1, dp);
    }

    /*
        TC - exponential
        SC - O(W)
     */
    int recursion(int[] val, int[] wt, int capacity, int index) {
        if(index == 0) {
            return (capacity/wt[0])  * val[0];
        }

        int notTake = recursion(val, wt, capacity, index  - 1);
        int take = 0;
        if(wt[index] <= capacity) take = val[index] + recursion(val, wt, capacity - wt[index], index);

        return Math.max(notTake, take);
    }

    int memoization(int[] val, int[] wt, int capacity, int index, int[][] dp) {
        if (index == 0) {
            return (capacity/wt[0]) * val[0];
        }

        if (dp[index][capacity] != -1)
            return dp[index][capacity];

        int notTake = memoization(val, wt, capacity, index - 1, dp);
        int take = 0;
        if (wt[index] <= capacity)
            take = val[index] + memoization(val, wt, capacity - wt[index], index, dp);

        return dp[index][capacity] = Math.max(notTake, take);
    }

    int tabulation(int[] val, int[] wt, int C) {
        int n = val.length;
        int[][] dp = new int[n][C + 1];

        for(int i = 0;i <= C;i++) {
            dp[0][i] = (i/wt[0]) * val[0];
        }

        for(int index = 1;index < n;index++) {
            for(int capacity = 0;capacity <= C;capacity++) {
                int notTake = dp[index - 1][capacity];
                int take = 0;
                if (wt[index] <= capacity)
                    take = val[index] + dp[index][capacity - wt[index]];

                dp[index][capacity] = Math.max(notTake, take);
            }
        }

        return dp[n - 1][C];
    }

    int spaceOptimization(int[] val, int[] wt, int C) {
        int n = val.length;
        int[] prev = new int[C + 1];

        for(int i = 0;i <= C;i++) {
            prev[i] = (i/wt[0]) * val[0];
        }

        for(int index = 1;index < n;index++) {
            int[] cur = new int[C + 1];
            for(int capacity = 0;capacity <= C;capacity++) {
                int notTake = prev[capacity];
                int take = 0;
                if (wt[index] <= capacity)
                    take = val[index] + cur[capacity - wt[index]];

                cur[capacity] = Math.max(notTake, take);
            }
        }

        return cur[C];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}