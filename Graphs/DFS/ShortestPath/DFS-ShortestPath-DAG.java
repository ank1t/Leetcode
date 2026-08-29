import java.util.*;

class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<VertexCostPair>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0;i < V;i++) {
            adj.add(new ArrayList<>());
            ans.add(Integer.MAX_VALUE);
        }

        for(int[] edge: edges) {
            VertexCostPair pair = new VertexCostPair(edge[1], edge[2]);
            adj.get(edge[0]).add(pair);
        }

        for(int i = 0;i < V;i++) {
            if(!visited[i]) {
                dfs(stack, adj, visited, i);
            }
        }

        boolean node0Hit = false;
        ans.set(0, 0);
        while(!stack.isEmpty()) {
            Integer node = stack.pop();
            /*
                Elements appearing before a given element in the stack cannot be reached by the given element.
                So we keep popping them off the stack and setting -1 in ans list.
             */
            if (!node0Hit) {
                if (node == 0) {
                    node0Hit = true;
                } else {
                    ans.set(node, -1);
                    continue;
                }
            }

            for (VertexCostPair pair : adj.get(node)) {
                int v = pair.neighbor;
                int wt = pair.cost;
                if (ans.get(node) + wt < ans.get(v)) {
                    ans.set(v, ans.get(node) + wt);
                }
            }
        }
       return ans;
    }

    void dfs(Stack<Integer> stack, ArrayList<ArrayList<VertexCostPair>> adj,
             boolean[] visited, int node) {
        visited[node] = true;

        for(VertexCostPair pair : adj.get(node)) {
            if(!visited[pair.neighbor]) {
                dfs(stack, adj, visited, pair.neighbor);
            }
        }
        stack.push(node);
    }
}

class VertexCostPair {
    int neighbor;
    int cost;

    VertexCostPair(int neighbor, int cost) {
        this.neighbor = neighbor;
        this.cost = cost;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges2 =  {{0,2,6}, {0,3,7}, {0,4,9}, {0,6,8}, {0,7,6}, {1,2,6}, {1,3,7},{1,5,10},{1,6,1},{1,7,4},{2,3,3},
                {2,6,10},{2,8,8},{2,9,10},{3,5,3},{3,6,10},{3,7,5},{5,6,9},{5,7,7},{6,7,7},{6,8,8},{6,9,8},{7,9,1},{8,9,6}};



        System.out.println(sol.shortestPath(10, edges2));
    }
}