import java.util.*;

class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = buildAdjList(edges, V);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.wt - y.wt);
        int[] dist = new int[V];
        for(int i = 0;i < V;i++) dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();

            for(Pair p : adj.get(pair.node)) {
                int wt = p.wt;
                int adjNode = p.node;

                if(pair.wt + wt < dist[adjNode]) {
                    dist[adjNode] = pair.wt + wt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0;i < V;i++) {
            ans.add(dist[i]);
        }
        return ans;
    }

    ArrayList<ArrayList<Pair>> buildAdjList(int[][] edges, int V) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i < V;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        return adj;
    }
}

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        System.out.println(solution.dijkstra(3, edges, 2));;
    }
}