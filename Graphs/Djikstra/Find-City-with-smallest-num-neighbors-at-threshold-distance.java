import java.util.*;

class Solution {
    int infinity = 1_000_000_00;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = buildAdjMatrix(n, edges);
        int minCount = Integer.MAX_VALUE;
        int count = 0;
        int cityIndex = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjMatrix[i][k] == infinity || adjMatrix[k][j] == infinity)
                        continue;
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if(adjMatrix[i][j] <= distanceThreshold) count++;
            }
            if(count <= minCount) {
                minCount = count;
                cityIndex = i;
            }
        }
        return cityIndex;
    }

    int[][] buildAdjMatrix(int n, int[][] edges) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = infinity;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        return dist;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        System.out.println(sol.findTheCity(4, edges, 4));
    }
}