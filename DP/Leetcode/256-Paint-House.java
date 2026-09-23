import java.util.*;

class Solution {
    int minCost(int[][] costs) {
        f(0, 3, costs, costs.length);
    }

    //Plain recursion
    int f(int index, int last, int[][] costs, int m) {
        if(index == m) return 0;

        int min = Integer.MAX_VALUE;
        for(int i = 0;i < 3;i++) {
            if(i != last) {
                min = Math.min(min, costs[index][i] + f(index + 1, i, costs, m));
            }
        }
        return min;
    }

    /*
        Recursion + memoization
        int[][] dp = new int[m][n + 1];
     */
    int f(int index, int last, int[][] costs, int m, int[][] dp) {
        if(index == m) return 0;

        if(dp[index][last] != 0) return dp[index][last];
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < 3;i++) {
            if(i != last) {
                min = Math.min(min, costs[index][i] + f(index + 1, i, costs, m));
            }
        }
        return dp[index][last] = min;
    }

    /*
        Space optimization
     */

    int f(int[][] costs) {
        int n = costs.length;
        int[] prev = new int[4];

        prev[0] = Math.min(costs[0][1], costs[0][2]);
        prev[1] = Math.min(costs[0][0], costs[0][2]);
        prev[2] = Math.min(costs[0][0], costs[0][1]);
        prev[3] = Math.min(costs[0][1], Math.min(costs[0][0], costs[0][2]));

        for(int day = 1;day < n;day++) {
            int[] cur = new int[4];
            for(int last = 0;last < 4;last++) {
                int min = Integer.MAX_VALUE;
                for(int task = 0;task < 3;task++) {
                    if(last != task) {
                        /*
                            prev[task] is the best value for all tasks where task != last
                            prev[0] contains the min value for painting house blue or green
                         */
                        min = Math.min(min, costs[day][task] + prev[task]);
                    }
                }
                cur[last] = min;
            }
            prev = cur;
        }
        return prev[3];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}