import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] indegree = new int[graph.length];
        ArrayList<ArrayList<Integer>> adj = reverseEdgesInGraph(graph, indegree);


        return findSafeNodesUsingBFS(adj, indegree);
    }

    ArrayList<Integer> findSafeNodesUsingBFS(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0;i < adj.size();i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int indegree0 = q.poll();

            for(Integer vertex: adj.get(indegree0)) {
                indegree[vertex]--;
                if(indegree[vertex] == 0) {
                    q.add(vertex);
                }
            }
        }

        for(int j = 0;j < indegree.length;j++) {
            if(indegree[j] == 0) ans.add(j);
        }
        return ans;
    }

    ArrayList<ArrayList<Integer>> reverseEdgesInGraph(int[][] graph, int[] indegree) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = graph.length;

        for(int i = 0;i < V;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i < V;i++) {
            for(int edge: graph[i]) {
                adj.get(edge).add(i);
                indegree[i]++;
            }
        }
        return adj;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(sol.eventualSafeNodes(graph));
    }
}