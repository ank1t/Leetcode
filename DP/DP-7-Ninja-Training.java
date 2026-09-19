class Solution {
    //Top down
    public int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        return f(n - 1, 3, points);
    }

    int f(int day, int last, int[][] points) {
        if(day == 0) {
            int max = 0;
            for(int i = 0;i < 3;i++) {
                if(i != last) {
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
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
        if(day == 0) {
            if(dp[day][last] != 0) return dp[day][last];

            int max = 0;
            for(int i = 0;i < 3;i++) {
                if(i != last) {
                    max = Math.max(max, points[day][i]);
                }
            }
            return dp[day][last] = max;
        }

        int max = 0;
        for(int i = 0;i < 3;i++) {
            if (i != last) {
                max = Math.max(points[day][i] + f(day - 1, i, points, dp), max);
                dp[day][i] = max;
            }
        }

        max = 0;
        for(int i = 0;i < 3;i++) {
            max = Math.max(max, dp[day][i]);
        }
        return max;
    }

    //Bottom up
    public int ninjaTrainingBU(int n, int[][] points) {
        return fBU(0, 3, points, n);
    }

    int fBU(int day, int last, int[][] points, int n) {
        if(day == n - 1) {
            int maxL = 0;
            for(int i = 0;i < 3;i++) {
                if(i != last) maxL = Math.max(maxL, points[day][i]);
            }
            return maxL;
        }

        int max = 0;
        for(int i = 0;i < n;i++) {
            if(i != last) {
                max = Math.max(max, points[day][i] + fBU(day + 1, i, points, n));
            }
        }
        return max;
    }

    //Bottom Up memoized
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] points1 = new int[][] {{1,2,5},{3,1,1},{3,3,3}};
        int[][] points2 = new int[][] {{10,40,70},{20,50,80},{30,60,90}};
        int[][] points3 = new int[][] {{18,11,19},{4,13,7},{1,8,13}};
        int[][] points4 = new int[][] {{10,50,1},{5,100,1}};

        System.out.println(sol.ninjaTrainingBU(2, points4));
    }
}