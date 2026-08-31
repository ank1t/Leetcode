import java.util.*;

class Solution {
    List<int[]>[] buildAdjList(int[][] edges, int n) {
        List<int[]>[] list = new ArrayList[n];

        for(int i = 0;i < n;i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            list[u].add(new int[]{v, wt});
            list[v].add(new int[]{u, wt});
        }
        return list;
    }

    ArrayList<Integer> shortestPath(int n, int V, int[][] edges) {
        List<int[]>[] adj = buildAdjList(edges, V);
        int[] dist = new int[V];
        int[] parent = new int[V];
        TreeSet<int[]> set = new TreeSet<>((int[]a, int[] b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        Arrays.fill(dist, Integer.MAX_VALUE);
        set.add(new int[]{1, 0});
        dist[1] = 0;
        parent[1] = -1;

        while(!set.isEmpty()) {
            int[] pair = set.pollFirst();
            int u = pair[0];

            for(int[] adjVertWt : adj[u]) {
                int v = adjVertWt[0];
                int wt2 = adjVertWt[1];

                if(dist[v] > dist[u] + wt2) {

                    if(dist[v] != Integer.MAX_VALUE) {
                        set.remove(new int[]{v, dist[v]});
                    }
                    dist[v] = dist[u] + wt2;
                    parent[v] = u;
                    set.add(new int[]{v, dist[v]});
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if(dist[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        };

        int index = n;
        ans.add(n);
        while(parent[index] != -1) {
            ans.add(0, parent[index]);
            index = parent[index];
        }

        return ans;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4},{1,4,1},{4,3,3},{3,5,1}};
        System.out.println(sol.shortestPath(5, 6, edges));;
    }
}