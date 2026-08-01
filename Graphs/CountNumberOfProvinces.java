import java.util. *;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0;i < n;i++) {
            if(!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected,
                     int node,
                     boolean[] visited) {
        visited[node] = true;

        for (int i = 0;i < isConnected.length;i++) {
            if (!visited[i] && isConnected[node][i] == 1) dfs(adj, adjVertex, visited);
        }
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