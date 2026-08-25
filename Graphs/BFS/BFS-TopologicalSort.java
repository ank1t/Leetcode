import java.util.*;

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int[] indegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges, indegree);
        return topoSortBFS(V, adj, indegree);
    }

    ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges, int[] indegree) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < V;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]] = indegree[edge[1]] + 1;
        }
        return adj;
    }

    ArrayList<Integer> topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0;i < V;i++) {
            if(indegree[i] == 0) {
                ans.add(i);
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int vertex = q.poll();

            for(int adjV: adj.get(vertex)) {
                int currentDegree = indegree[adjV];
                currentDegree--;
                indegree[adjV] = currentDegree;
                if(currentDegree == 0) {
                    q.add(adjV);
                    ans.add(adjV);
                }
            }
        }

        return ans;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {
                {3, 0},
                {1, 0},
                {2, 0}
        };
        System.out.println(sol.topoSort(4, edges));
    }
}