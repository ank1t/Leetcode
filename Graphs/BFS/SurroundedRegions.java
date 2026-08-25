import java.util.*;

class Solution {
    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        Queue<RowColPair> q = new LinkedList<>();
        boolean[] visited = new boolean[m * n];
        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};

        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    q.add(new RowColPair(i,j));
                    visited[i * n + j] = true;

                    while(!q.isEmpty()) {
                        RowColPair pair = q.poll();

                        for(int[] direction: directions) {
                            int newRow = pair.row + direction[0];
                            int newCol = pair.col + direction[1];

                            if(isValid(newRow, newCol, board) && !visited[newRow * n + newCol]) {
                                q.add(new RowColPair(newRow, newCol));
                                visited[newRow * n + newCol] = true;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(board[i][j] == 'O' && !visited[i * n + j]) board[i][j] = 'X';
            }
        }
    }

    boolean isValid(int row, int col, char[][] grid) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 'O';
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

class SurroundedRegios {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        sol.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}