import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        bfs(image, color, image[sr][sc], sr, sc);
        return image;
    }

    private void bfs(int[][] image, int color, int ogColor, int sr, int sc) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sr, sc));

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;
            image[row][col] = color;

            if(row - 1 >= 0 && image[row - 1][col] == ogColor) {
                q.add(new Pair(row - 1, col));
            }

            if(row + 1 < image.length && image[row + 1][col] == ogColor) {
                q.add(new Pair(row + 1, col));
            }

            if(col - 1 >= 0 && image[row][col - 1] == ogColor) {
                q.add(new Pair(row, col - 1));
            }

            if(col + 1 < image[0].length && image[row][col + 1] == ogColor) {
                q.add(new Pair(row, col + 1));
            }
        }
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        System.out.println(Arrays.deepToString(sol.floodFill(image, 1, 1, 2)));
    }
}