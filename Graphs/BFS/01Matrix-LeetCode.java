import java.util.*;

class Solution {
    int m, n;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[] visited = new boolean[m * n];
        Queue<RowColCount> q = new LinkedList<>();

        findAll1s(dist, mat, visited, q);
        findNearest1(dist, mat, visited, q);

        return dist;
    }

    void findNearest1(int[][] dist, int[][] mat,
                      boolean[] visited, Queue<RowColCount> q) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!q.isEmpty()) {
            RowColCount rcc = q.poll();
            int row = rcc.row, col = rcc.col, steps = rcc.count;

            for (int[] direction: directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (valid(nextRow, nextCol) && !visited[nextRow * n + nextCol]) {
                    visited[nextRow * n + nextCol] = true;
                    q.add(new RowColCount(nextRow, nextCol, steps + 1));
                    dist[nextRow][nextCol] = steps + 1;
                }
            }
        }
    }

    public boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }

    void findAll1s(int[][] dist, int[][] mat,
                   boolean[] visited, Queue<RowColCount> q) {
        int row = mat.length;
        int col = mat[0].length;

        for(int i = 0;i < row;i++) {
            for(int j = 0;j < col;j++) {
                if(mat[i][j] == 0) {
                    q.add(new RowColCount(i, j, 0));
                    visited[i * col + j] = true;
                }
            }
        }
    }
}

class RowColCount {
    int row;
    int col;
    int count;

    RowColCount(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };
        System.out.println(Arrays.deepToString(sol.updateMatrix(mat)));
    }
}