import java.util.*;

/*
    For unweighted graphs, the first time we visit the node will be the shortest path
 */

class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        int[] dist = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        Queue<Integer> q = new LinkedList<>();

        for(int j = 0;j < V;j++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(src);
        dist[src] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int adjV : adj.get(node)) {
                if(adjV == dest) return dist[node] + 1;
                else if(dist[adjV] == Integer.MAX_VALUE) {
                    dist[adjV] = dist[node] + 1;
                    q.add(adjV);
                }
            }
        }
        return -1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = {{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        int[][] edges2 = {{1, 2}, {0, 3}, {0, 1}, {0, 2}, {1, 3}};
        System.out.println(sol.shortestPath(4, edges2, 2, 1));
    }
}