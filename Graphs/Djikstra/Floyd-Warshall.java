import java.util.*;

class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int infinity = 1_000_000_00;

        for(int k = 0;k < n;k++) {
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < n;j++) {
                    if(dist[i][k] == infinity || dist[k][j] == infinity) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int infinity = 1_000_000_00;
        int[][] edges =  {{0, 4, infinity, 5, infinity}, {infinity, 0, 1, infinity, 6}, {2, infinity, 0, 3, infinity}, {infinity, infinity, 1, 0, 2}, {1, infinity, infinity, 4, 0}};
        sol.floydWarshall(edges);
        System.out.println(Arrays.deepToString(edges));
    }
}