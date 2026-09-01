import java.util.*;

class Pair {
    int nodeX;
    int nodeY;
    int wt;

    Pair(int nodeX, int nodeY, int wt) {
        this.nodeX = nodeX;
        this.nodeY = nodeY;
        this.wt = wt;
    }
}

class Solution {
    int n;
    int m;
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        if(mat[dest[0]][dest[1]] == 0) return -1;
        if(src[0] == dest[0] && src[1] == dest[1]) return 0;

        n = mat.length;
        m = mat[0].length;

        int[][] dist = new int[n][m];
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] row : dist) { Arrays.fill(row, Integer.MAX_VALUE); }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src[0], src[1], 0));
        dist[src[0]][src[1]] = 0;

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int oldX = pair.nodeX;
            int oldY = pair.nodeY;
            int wt = pair.wt;

            int destX = dest[0];
            int destY = dest[1];
            if(oldX == destX && oldY == destY) { return wt; }

            for(int[] dir : dirs) {
                if(isValid(oldX + dir[0], oldY + dir[1], oldX, oldY, mat, dist)) {
                    q.add(new Pair(oldX + dir[0], oldY + dir[1], wt + 1));
                    dist[oldX + dir[0]][oldY + dir[1]] = wt + 1;
                }
            }
        }
        return -1;
    }

    boolean isValid(int newX, int newY, int oldX, int oldY,
                    int[][] mat, int[][] dist) {
        return newX >= 0 && newX < n && newY >= 0 && newY < m && mat[newX][newY] == 1 &&
                dist[newX][newY] > dist[oldX][oldY] + 1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.shortestPath(new int[][]{{1,1,1,1},{1,1,0,1},{1,1,1,1},{1,1,0,0},{1,0,0,1}},
                                            new int[]{0,1}, new int[]{2,2}));
    }
}