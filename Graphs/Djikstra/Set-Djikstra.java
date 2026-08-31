import java.util.*;

class Solution {
    List<int[]>[] constructAdj(int[][] edges, int V) {

        // Initialize the adjacency list
        List<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        // Fill the adjacency list from edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj[u].add(new int[]{v, wt});
            adj[v].add(new int[]{u, wt});
        }

        return adj;
    }

    // Returns shortest distances from src to all other vertices
    int[] shortestPath(int V, int[][] edges, int src) {

        // Create adjacency list
        List<int[]>[] adj = constructAdj(edges, V);

        // TreeSet to store vertices that are being preprocessed.
        // It stores pairs as {distance, vertex} and automatically keeps them sorted.
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Create a vector for distances and initialize
        // all distances as infinite
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Insert source itself in TreeSet and
        // initialize its distance as 0.
        set.add(new int[]{0, src});
        dist[src] = 0;

        // Looping till TreeSet becomes empty
        // (or all distances are not finalized)
        while (!set.isEmpty()) {
            // The first vertex in pair is the minimum distance
            // vertex, extract it from TreeSet.
            int[] top = set.pollFirst();
            int u = top[1];

            // Get all adjacent of u.
            for (int[] x : adj[u]) {

                // Get vertex label and weight of current adjacent of u.
                int v = x[0];
                int weight = x[1];

                // If there is shorter path to v through u.
                if (dist[v] > dist[u] + weight) {

                    if (dist[v] != Integer.MAX_VALUE) {
                        set.remove(new int[]{dist[v], v});
                    }

                    // Updating distance of v
                    dist[v] = dist[u] + weight;
                    set.add(new int[]{dist[v], v});
                }
            }
        }

        // Return the shortest distance array
        return dist;
    }
}

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() == o.getClass()) return false;
        Pair pair = (Pair)o;
        return node == pair.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        System.out.println(Arrays.toString(sol.shortestPath(3, edges, 2)));;
    }
}