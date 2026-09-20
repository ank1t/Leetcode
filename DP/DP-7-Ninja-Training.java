//https://www.naukri.com/code360/problems/ninja’s-training_3621003
class Solution {
    //Top down
    public int ninjaTraining(int n, int[][] points) {
        return f(n - 1, 3, points);
    }

    int f(int day, int last, int[][] points) {
        if(day == -1) {
            return 0;
        }

        int max = 0;
        for(int i = 0;i < 3;i++) {
            if (i != last) {
                max = Math.max(points[day][i] + f(day - 1, i, points), max);
            }
        }
        return max;
    }

    //Top down memoized
    public int ninjaTrainingTDM(int n, int[][] points) {
        int[][] dp = new int[n][4];
        return f(n - 1, 3, points, dp);
    }

    int f(int day, int last, int[][] points, int[][] dp) {
        if(day == -1) {
            return 0;
        }

        if(dp[day][last] != 0) return dp[day][last];

        int max = 0;
        for(int i = 0;i < 3;i++) {
            if (i != last) {
                max = Math.max(points[day][i] + f(day - 1, i, points, dp), max);
            }
        }
        return dp[day][last] = max;
    }

    //Bottom up
    public int ninjaTrainingBU(int n, int[][] points) {
        return fBU(0, 3, points, n);
    }

    int fBU(int day, int last, int[][] points, int n) {
        if(day == n) {
            return 0;
        }

        int max = 0;
        for(int i = 0;i < 3;i++) {
            if(i != last) {
                max = Math.max(max, points[day][i] + fBU(day + 1, i, points, n));
            }
        }
        return max;
    }

    /*
        Bottom Up memoized
        dp[0][3] will contain the solution.
     */
    public int ninjaTrainingBUM(int n, int[][] points) {
        int[][] dp = new int[n][4];
        return fBUM(0, 3, points, n, dp);
    }

    int fBUM(int day, int last, int[][] points, int n, int[][] dp) {
        if(day == n) {
            return 0;
        }

        if(dp[day][last] != 0) return dp[day][last];
        int max = 0;
        for(int i = 0;i < 3;i++) {
            if (i != last) {
                max = Math.max(max, points[day][i] + fBUM(day + 1, i, points, n, dp));
            }
        }
        return dp[day][last] = max;
    }

    //Tabulation
    public int ninjaTrainingTab(int n, int[][] points) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for(int day = 1;day < n;day++) {
            for(int last = 0; last < 4; last++) {
                int max = 0;
                for(int task = 0;task < 3;task++) {
                    if(task != last) {
                        max = Math.max(max, points[day][task] + dp[day - 1][task]);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[n - 1][3];
    }

    //Space optimization
    public int ninjaTrainingSpaceOptimization(int n, int[][] points) {
        int[] dp = new int[4];
        int[] temp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for(int day = 1;day < n;day++) {
            for(int last = 0; last < 4; last++) {
                int max = 0;
                for(int task = 0;task < 3;task++) {
                    if(task != last) {
                        max = Math.max(max, points[day][task] + dp[task]);
                    }
                }
                temp[last] = max;
            }
            dp = temp;
        }
        return dp[3];
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] points1 = new int[][] {{1,2,5},{3,1,1},{3,3,3}}; //11
        int[][] points2 = new int[][] {{10,40,70},{20,50,80},{30,60,90}};//210
        int[][] points3 = new int[][] {{18,11,19},{4,13,7},{1,8,13}};//45
        int[][] points4 = new int[][] {{10,50,1},{5,100,1}};//110
        int[][] points5 = new int[][] {{2,1,3},{3,4,6},{10,1,6},{8,3,7}};//25

        System.out.println(sol.ninjaTrainingSpaceOptimization(2, points4));
    }
}