import java.util.ArrayList;
import java.util.List;

/*
    Time complexity: O(n) + 2 * E
 */
class Solution {
    ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size() + 1];
        visited[0] = true;

        traverseChildren(adj, visited, dfs, 3);

        return dfs;
    }

    private void traverseChildren(ArrayList<ArrayList<Integer>> adj,
                             boolean[] visited,
                             ArrayList<Integer> dfs,
                             int node) {
        visited[node] = true;
        dfs.add(node);

        for(int adjVertex: adj.get(node)) {
            if(!visited[node]) {
                traverseChildren(adj, visited, dfs, adjVertex);
            }
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> adj = generateAdjList();
        System.out.println(sol.dfs(adj));
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