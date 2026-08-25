import java.util.*;

class Solution {
    boolean detectCycle(int V, int[][] edges) {
        int[] inDegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = buildAdjacencyList(V, edges, inDegree);
        return bfs(V, adj, inDegree);
    }

    ArrayList<ArrayList<Integer>> buildAdjacencyList(int V, int[][] edges, int[] inDegree) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0;i < V;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        return adjList;
    }

    boolean bfs(int V, ArrayList<ArrayList<Integer>> adj, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0;i < V;i++) {
            if(inDegree[i] == 0) {
                count++;
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int vertex = q.poll();

            for(int adjVertex: adj.get(vertex)) {
                inDegree[adjVertex]--;
                if(inDegree[adjVertex] == 0) {
                    q.add(adjVertex);
                    count++;
                }
            }
        }

        return count != V;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{1, 2}, {2, 3}, {3, 5}, {3, 4}, {4, 2}}   ;
        System.out.println(sol.detectCycle(6, edges));
    }
}