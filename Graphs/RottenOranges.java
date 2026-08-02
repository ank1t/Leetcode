import java.util.*;

class Solution {
    {
        if(!checkIfThereAreAnyFreshOranges(grid)) return 0;
        int minTime = 0;
        Queue<PairTime> q = findAllRottenOranges(grid);

        while(!q.isEmpty()) {
            PairTime pair = q.poll();
            int row = pair.row;
            int col = pair.col;
            int time = pair.time;
            if(grid[row][col] == 2 && time > 0) continue;

            minTime = Math.max(time, minTime);

            grid[row][col] = 2;

            if(row - 1 >= 0 && grid[row - 1][col] == 1) {
                q.add(new PairTime(row - 1, col, time + 1));
            }

            if(row + 1 < grid.length && grid[row + 1][col] == 1) {
                q.add(new PairTime(row + 1, col, time + 1));
            }

            if(col - 1 >= 0 && grid[row][col - 1] == 1) {
                q.add(new PairTime(row, col - 1, time + 1));
            }

            if(col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                q.add(new PairTime(row, col + 1, time + 1));
            }
        }

        return checkIfThereAreAnyFreshOranges(grid) ? -1 : minTime;
    }


    boolean checkIfThereAreAnyFreshOranges(int[][] grid) {
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                if(grid[i][j] == 1) return true;
            }
        }
        return false;
    }

    Queue<PairTime> findAllRottenOranges(int[][] grid) {
        Queue<PairTime> list = new LinkedList<PairTime>();

        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                if(grid[i][j] == 2) list.add(new PairTime(i, j, 0));
            }
        }
        return list;
    }
}

class PairTime {
    int row;
    int col;
    int time;

    PairTime(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        sol.orangesRotting(grid);
    }
}