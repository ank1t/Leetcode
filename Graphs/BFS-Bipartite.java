import java.util.*;

//https://leetcode.com/problems/is-graph-bipartite/description/

class Solution {
    int m;

    public boolean isBipartite(int[][] graph) {
        m = graph.length;
        int[] colorOfVertex = new int[m];
        int lastColorID = 1;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < m;i++) {
            if(colorOfVertex[i] != 0) continue;

            q.add(i);
            colorOfVertex[i] = lastColorID;

            while (!q.isEmpty()) {
                int num = q.poll();
                if(graph[num].length > 0) {
                    lastColorID = colorOfVertex[num] == 1 ? 2 : 1;
                }

                for (int adjVertex : graph[num]) {
                    if (colorOfVertex[adjVertex] == colorOfVertex[num]) return false;
                    if (colorOfVertex[adjVertex] == 0) {
                        q.add(adjVertex);
                        colorOfVertex[adjVertex] = lastColorID;
                    }
                }
            }
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

        System.out.println(sol.isBipartite(graph1));
    }
}