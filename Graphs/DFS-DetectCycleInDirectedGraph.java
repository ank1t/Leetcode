import java.util. *;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = createAdjList(edges, V);

        for(int i = 0;i < V;i++) {
            if(!visited[i]) {
                visited[i] = true;
                pathVisited[i] = true;

                if(dfs(adj, visited, pathVisited, i)) return true;
            }
        }
        return false;
    }

    ArrayList<ArrayList<Integer>> createAdjList(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0;i < V;i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
        }
        return list;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node) {

        for(int vertex: adj.get(node)) {
            if(!visited[vertex]) {
                visited[vertex] = true;
                pathVisited[vertex] = true;
                if(dfs(adj, visited, pathVisited, vertex)) return true;
                pathVisited[vertex] = false;
            } else {
                if(pathVisited[vertex]) return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{3, 0}, {4, 2}, {1, 2}};
        System.out.println(sol.isCyclic(5, edges));
    }
}