import java.util. *;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adj = convertToAdjList(isConnected);
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0;i < n;i++) {
            if(!visited[i]) {
                count++;
                dfs(adj, i, visited);
            }
        }
        return count;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj,
                     int node,
                     boolean[] visited) {
        visited[node] = true;

        for(int adjVertex: adj.get(node)) {
            if(!visited[adjVertex]) dfs(adj, adjVertex, visited);
        }
    }
    public ArrayList<ArrayList<Integer>> convertToAdjList(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i < isConnected[0].length;i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int k = 0;k < isConnected[0].length;k++) {
                if(i != k && isConnected[i][k] == 1) {
                    list.add(k);
                }
            }
            adj.add(list);
        }
        return adj;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        sol.findCircleNum(isConnected);
    }
}