import java.util.*;

class Solution {
    int m;

    public boolean isBipartite(int[][] graph) {
        m = graph.length;
        int[] color = new int[m];

        for(int j = 0;j < m;j++) {
            if(color[j] == 0) {
            color[j] = 1;
            if(!dfs(graph, color, j, 1)) return false;
            }
        }
        return true;
    }

    boolean dfs(int[][] graph, int[] color, int node, int colorID) {

        for(int adj: graph[node]) {
            if(color[adj] == color[node]) return false;
            if(color[adj] != 0) continue;
            color[adj] = colorID == 1 ? 2 : 1;
            if(!dfs(graph, color, adj, colorID == 1 ? 2 : 1)) return false;
        }
        return true;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();

        //false
        int[][] graph1 = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };

        //true
        int[][] graph2 = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };

        //true
        int[][] graph3 = {
                {},
                {3},
                {},
                {1},
                {}
        };

        //false
        int[][] graph4 = {
                {},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}
        };

        //true
        int[][] graph5 = {{1},{0,3}, {3},{1,2}};

        Map<int[][], Boolean> dict = new HashMap<>();
        dict.put(graph1, false);
        dict.put(graph2, true);
        dict.put(graph3, true);
        dict.put(graph4, false);
        dict.put(graph5, true);

        for(Map.Entry<int[][], Boolean> map: dict.entrySet()) {
            System.out.println(sol.isBipartite(map.getKey()) == map.getValue());
        }
    }
}