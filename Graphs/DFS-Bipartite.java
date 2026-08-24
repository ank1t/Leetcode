import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {

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