import java.util.*;

class Solution {
    int m, n;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<RowColPair> q = new LinkedList<>();
        boolean[] visited = new boolean[m * n];
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int numOfClosedIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0 && !visited[i * n + j]) {
                    boolean canCountInResult = true;
                    q.add(new RowColPair(i, j));
                    visited[i * n + j] = true;
                    canCountInResult = !isBorderCell(i, j);

                    while (!q.isEmpty()) {
                        RowColPair pair = q.poll();

                        for (int[] direction : directions) {
                            int newRow = pair.row + direction[0];
                            int newCol = pair.col + direction[1];

                            if (isValid(newRow, newCol, grid) && !visited[newRow * n + newCol]) {
                                canCountInResult = canCountInResult && !isBorderCell(newRow, newCol);
                                q.add(new RowColPair(newRow, newCol));
                                visited[newRow * n + newCol] = true;
                            }
                        }
                    }
                    if (canCountInResult)
                        numOfClosedIslands++;
                }
            }
        }
        return numOfClosedIslands;
    }

    boolean isBorderCell(int row, int col) {
        return row == 0 || row == m - 1 || col == 0 || col == n - 1;
    }

    boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0;
    }
}

class RowColPair {
    int row;
    int col;

    RowColPair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(sol.closedIsland(grid));
    }
}