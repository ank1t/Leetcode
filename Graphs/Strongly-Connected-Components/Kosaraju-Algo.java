import java.util.*;

class Solution {
    public int countSCC(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = buildAdjList(edges, V);
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        int scc = 0;

        //Get the finishing time
        for(int i = 0;i < V;i++) {
            if(!visited[i]) {
                dfs(i, visited, adj, stack);
            }
        }

        //Reverse the graph
        for(int i = 0;i < V;i++) {
            adjT.add(new ArrayList<>());
        }
        for(int i = 0;i < V;i++) {
            visited[i] = false;
            for(int adjV : adj.get(i)) {
                adjT.get(adjV).add(i);
            }
        }

        //DFS again

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(!visited[node]) {
                scc++;
                dfs3(node, visited, adjT);
            }
        }
        return scc;
    }

    private void dfs3(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for(int adjV : adj.get(node)) {
            if(!visited[adjV]) dfs3(adjV, visited, adj);
        }
    }

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj,
                     Stack<Integer> stack) {
        visited[node] = true;
        for(int adjV : adj.get(node)) {
            if(!visited[adjV]) dfs(adjV, visited, adj, stack);
        }
        stack.push(node);
    }
    private ArrayList<ArrayList<Integer>> buildAdjList(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i < V;i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}