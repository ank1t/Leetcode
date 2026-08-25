import java.util.*;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        return detectCycleUsingDFS(visited, buildAdjList(edges, V));
    }

    private ArrayList<ArrayList<Integer>> buildAdjList(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> ();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        return list;
    }

    private boolean detectCycleUsingDFS(boolean[] visited,
                                        ArrayList<ArrayList<Integer>> adj) {

        for (int k = 0; k < adj.size(); k++) {
            if (!visited[k]) {
                if(dfs(visited, new VertexParentPair(k, -1), adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(boolean[] visited, VertexParentPair pair,
                        ArrayList<ArrayList<Integer>> adj) {
        visited[pair.val] = true;

        for (int adjVertex: adj.get(pair.val)) {
            if(!visited[adjVertex]) {
                if(dfs(visited, new VertexParentPair(adjVertex, pair.val), adj)) return true;
            }
            else if(pair.parent != adjVertex) return true;
        }
        return false;
    }
}

class VertexParentPair {
    int val;
    int parent;

    VertexParentPair(int val, int parent) {
        this.val = val;
        this.parent = parent;
    }
}


class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {
                {0,1},
                {1,2},
                {1,3},
                {2,4},
                {3,4},
                {4,5}
        };

        System.out.println(sol.isCycle(6, edges));
    }
}