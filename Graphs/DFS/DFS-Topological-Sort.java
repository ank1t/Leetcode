class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        buildAdjList(V, edges, adj);

        for(int i = 0;i < V;i++) {
            if(!visited[i]) dfs(adj, visited, stack, i);
        }

        for(int i = 0;i < V;i++) {
            ans.add(stack.pop());
        }
        return ans;
    }

    void buildAdjList(int V, int[][] edges, ArrayList<ArrayList<Integer>> adj) {

        for(int i = 0;i < V;i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited,
             Stack<Integer> stack, int node) {
        visited[node] = true;

        for(int vertex: adj.get(node)) {
            if(!visited[vertex]) {
                dfs(adj, visited, stack, vertex);
            }
        }

        stack.push(node);
    }

}