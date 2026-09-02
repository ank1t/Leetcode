import java.util.*;

class Solution {
    int n, m;
    public int minimumEffortPath(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        int[][] dist = new int[n][m];
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> set = new PriorityQueue<>((int[] x,int[] y) -> x[0] - y[0]);

        for(int[] row : dist) { Arrays.fill(row, Integer.MAX_VALUE); }
        dist[0][0] = 0;
        //Storing data in the form (dist, x, y)
        set.add(new int[]{0,0,0});

        while(!set.isEmpty()) {
            int[] cell = set.poll();
            int maxEffort = cell[0];
            int curX = cell[1];
            int curY = cell[2];

            if(curX == n - 1 && curY == m - 1) return maxEffort;

            for(int[] dir : dirs) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];
                if(isValid(n, m, newX, newY)) {
                    int newEffort = Math.max(Math.abs(heights[curX][curY] - heights[newX][newY]), maxEffort);
                    if(newEffort < dist[newX][newY]) {
                        dist[newX][newY] = newEffort;
                        set.add(new int[]{newEffort, newX, newY});
                    }
                }
            }
        }
        return 0;
    }

    boolean isValid(int n, int m, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] heights = {{10,8},{10,8},{1,2},{10,3},{1,3},{6,3},{5,2}};
        System.out.println(sol.minimumEffortPath(heights));



    }
}