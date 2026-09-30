import java.util.*;

class Solution {
    public int cherryPickup(int[][] grid) {

    }

    int f(int[][] grid, int row, int col1, int col2, int n, int m) {
        if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return -1_000_000;
        else if(row == n - 1) {
            if(col1 == col2) return grid[row][col1];
            return grid[row][col1] + grid[row][col2];
        }

        int max = -1;
        for(int delta1 = -1;delta1 < 2;delta1++) {
            for(int delta2 = -1;delta2 < 2;delta2++) {
                if(col1 == col2) max = Math.max(max, grid[row][col1] + f(grid, row + 1, col1 + delta1, col2 + delta2, n, m));
                else max = Math.max(max, grid[row][col1] + grid[row][col2] + f(grid, row + 1, col1 + delta1, col2 + delta2, n, m));
            }
        }

        return max;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}