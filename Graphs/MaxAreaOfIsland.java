class Solution {
    int m, n, maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        Queue<RowCol> q = new LinkedList<>();
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i * n + j]) {
                    q.add(new RowCol(i, j));
                    visited[i * n + j] = true;
                    int count = 0;

                    while (!q.isEmpty()) {
                        RowCol entry = q.poll();
                        count++;

                        for (int[] direction : directions) {
                            int newRow = entry.row + direction[0];
                            int newCol = entry.col + direction[1];

                            if (isValid(newRow, newCol, grid) && !visited[newRow * n + newCol]) {
                                q.add(new RowCol(newRow, newCol));
                                visited[newRow * n + newCol] = true;
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, count);
                }
            }
        }

        return maxArea;
    }

    boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1;
    }
}

class RowCol {
    int row;
    int col;

    RowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(sol.maxAreaOfIsland());
    }
}