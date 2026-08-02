import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        boolean[] visited = new boolean[row * col];

        for(int i = 0;i < row;i++) {
            for(int j = 0;j < col;j++) {
                if(!visited[i * col + j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, row, col, visited);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j,
                     int row, int col, boolean[] visited) {
        visited[i * col + j] = true;

        if(j - 1 < col && j - 1 >= 0 && !visited[i * col + j - 1] && grid[i][j - 1] == '1' ) {
            dfs(grid, i, j - 1, row, col, visited);
        }

        if(j + 1 < col && j + 1 >= 0 && !visited[i * col + j + 1] && grid[i][j + 1] == '1' ) {
            dfs(grid, i, j + 1, row, col, visited);
        }

        if(i - 1 < row && i - 1 >= 0 && !visited[(i - 1) * col + j] && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j, row, col, visited);
        }

        if(i + 1 < row && i + 1 >= 0 && !visited[(i + 1) * col + j] && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j, row, col, visited);
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(sol.numIslands(grid));
    }
}