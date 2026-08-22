import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> q = new LinkedList<>();

        //Mark as visited whenever a node is added to the Q
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            for(int adjVertex: adj.get(node)) {
                if(!visited[adjVertex]) {
                    q.add(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }

        return bfs;
    }
}

class BFS {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> adj = generateAdjList();
        System.out.println(sol.bfs(adj.size(), adj));
    }

    private static ArrayList<ArrayList<Integer>> generateAdjList() {
        /*
                         1
                       /   \
                      /     \
                     /       \
                    2         6
                   /  \     /   \
                  /    \   /     \
                 3      4  7     9
                       /    \
                      /      \
                     5--------8
         */
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>(List.of(2, 6)));
        adj.add(new ArrayList<Integer>(List.of(1, 3, 4)));
        adj.add(new ArrayList<Integer>(List.of(2)));
        adj.add(new ArrayList<Integer>(List.of(2, 5)));
        adj.add(new ArrayList<Integer>(List.of(4, 8)));
        adj.add(new ArrayList<Integer>(List.of(1, 7, 9)));
        adj.add(new ArrayList<Integer>(List.of(6, 8)));
        adj.add(new ArrayList<Integer>(List.of(5, 7)));
        adj.add(new ArrayList<Integer>(List.of(6)));
        return adj;
    }
}