import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        boolean[] visited = new boolean[m];
        boolean[] pathVisited = new boolean[m];
        boolean[] safeNode = new boolean[m];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0;i < m;i++) {
            if(!visited[i]) {
                dfs(graph, i, visited, pathVisited, safeNode);
            }
        }

        for(int i = 0;i < m;i++) {
            if(safeNode[i]) ans.add(i);
        }

        return ans;
    }

    boolean dfs(int[][] graph, int node,
                boolean[] visited, boolean[] pathVisited, boolean[] safeNode) {
        visited[node] = true;
        pathVisited[node] = true;
        safeNode[node] = false;

        for(int vertex: graph[node]) {
            if(!visited[vertex]) {
                if(!dfs(graph, vertex, visited, pathVisited, safeNode)) return false;
            } else {
                if(pathVisited[vertex]) return false;
            }
        }

        pathVisited[node] = false;
        safeNode[node] = true;

        return true;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph1 = {{1,2},{2,3}, {5},{0},{5},{}, {}};
        int[][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(sol.eventualSafeNodes(graph1));
    }
}