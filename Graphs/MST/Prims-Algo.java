import java.util.*;

class Pair {
    int wt;
    int node;

    Pair(int wt, int node) {
        this.wt = wt;
        this.node = node;
    }
}
class Solution {
    ArrayList<ArrayList<Pair>> buildAdj(int[][] edges, int V) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i < V;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        return adj;
    }

    int findMST(int[][] edges, int V) {
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b) -> a.wt - b.wt);
        int sum = 0;
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Pair>> adj = buildAdj(edges, V);

        q.add(new Pair(0,0));
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int wt = pair.wt;
            int node = pair.node;

            if(visited[node]) continue;
            visited[node] = true;
            sum += wt;
            for(Pair adjV : adj.get(node)) {
                int adjVWt = adjV.wt;
                int adjVNode = adjV.node;

                q.add(new Pair(adjVWt, adjVNode));
            }
        }
        return sum;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{0,1,2},{0,2,1},{1,2,1},{2,4,2},{2,3,2},{4,3,1}};
        System.out.println(sol.findMST(edges, 5));;
    }
}