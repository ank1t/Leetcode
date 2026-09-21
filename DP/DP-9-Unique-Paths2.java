import java.util.*;

//https://leetcode.com/problems/unique-paths-ii/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    }

    //Raw recursion
    int f1(int[][] grid, int i, int j) {
        if(i == 0 && j == 0) return 1;
        else if(i < 0 || j < 0) return 0;
        if(grid[i][j] == 1) return 0;

        int up = f(grid, i - 1, j);
        int left = f(grid, i, j - 1);

        return up + left;
    }

    //Memoization - init dp with -1
    int f2(int[][] grid, int i, int j, int[][] dp) {
        if(i == 0 && j == 0 && grid[i][j] != 1) return 1;
        else if(i < 0 || j < 0) return 0;
        if(grid[i][j] == 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f(grid, i - 1, j, dp);
        int left = f(grid, i, j - 1, dp);

        return up + left;

    }

class Scratch {
    public static void main(String[] args) {
        
    }
}