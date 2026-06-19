import java.util.*;

class RatInAMaze {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.validPaths(grid)));
    }
}

class Solution {
    public String[] validPaths(int [][] grid) {
        ArrayList<String> ans = new ArrayList<>();
        if (grid[0][0] == 1) {
            getPaths(0, 0, grid, ans, "");
        }
        return ans.toArray(new String[0]);
    }

    void validPathsOptimized(int [][] grid) {
        ArrayList<String> ans = new ArrayList<>();
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        if(grid[0][0] == 1) getPathsOptimized(0, 0, grid, ans, "", di, dj, "DLRU");
    }

    public void getPathsOptimized(int i, int j, int [][] grid, ArrayList<String> ans, String path, int[] di, int[] dj, String dir) {
        if(i == grid.length - 1 && j == grid.length - 1) {
            ans.add(path);
            return;
        }

        for(int k = 0;k < dir.length();k++) {
            if(i + di[k] >= 0 && i + di[k] < grid.length && j + dj[k] >= 0 && j + dj[k] < grid[0].length && grid[i + di[k]][j + dj[k]] == 1) {
                grid[i][j] = 0;
                getPathsOptimized(i, j, grid, ans, path + dir.charAt(k), di, dj, dir);
                grid[i + di[k]][j + dj[k]] = 1;
            }
        }
    }

    public void getPaths(int i, int j, int[][] grid, ArrayList<String> ans, String path) {
        if(i == grid.length - 1 && j == grid.length - 1) {
            ans.add(path);
            return;
        }

        if(canGoDown(i, j, grid)) {
            grid[i][j] = 0;
            getPaths(i + 1, j, grid, ans, path + "D");
            grid[i][j] = 1;
        }
        if(canGoLeft(i, j, grid)) {
            grid[i][j] = 0;
            getPaths(i, j -1, grid, ans, path + "L");
            grid[i][j] = 1;
        }
        if(canGoRight(i, j, grid)) {
            grid[i][j] = 0;
            getPaths(i, j + 1, grid, ans, path + "R");
            grid[i][j] = 1;
        }
        if(canGoUp(i, j, grid)) {
            grid[i][j] = 0;
            getPaths(i - 1, j, grid, ans, path + "U");
            grid[i][j] = 1;
        }
    }

    boolean canGoDown(int i, int j, int[][] grid) {
        int n = grid.length;
        return (i + 1) <= n-1 && grid[i + 1][j] == 1;
    }

    boolean canGoUp(int i, int j, int[][] grid) {
        return i - 1 >= 0 && grid[i - 1][j] == 1;
    }

    boolean canGoRight(int i, int j, int[][] grid) {
        int n = grid.length;
        return (j + 1) <= (n - 1) && grid[i][j + 1] == 1;
    }

    boolean canGoLeft(int i, int j, int[][] grid) {
        return j - 1 >= 0 && grid[i][j - 1] == 1;
    }
}