import java.util.*;


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        return detectCycleUsingBFS(visited, buildAdjList(edges, V));
    }

    private ArrayList<ArrayList<Integer>> buildAdjList(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < V;i++){
            list.add(new ArrayList<Integer>());
        }


        for(int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        return list;
    }

    private boolean detectCycleUsingBFS(boolean[] visited,
                                        ArrayList<ArrayList<Integer>> adj) {
        Queue<VertexParentPair> q = new LinkedList<VertexParentPair>();

        for(int k = 0;k < adj.size();k++) {
            if(!visited[k]) {
                q.add(new VertexParentPair(k, -1));

                while(!q.isEmpty()) {
                    VertexParentPair pair = q.poll();
                    int vertex = pair.val;
                    int parent = pair.parent;
                    visited[vertex] = true;

                    for(int adjVertex: adj.get(vertex)) {
                        if(parent != adjVertex) {
                            if (visited[adjVertex]) return true;
                            else {
                                q.add(new VertexParentPair(adjVertex, vertex));
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

class VertexParentPair {
    int val;
    int parent;

    VertexParentPair(int val, int parent) {
        this.val = val;
        this.parent = parent;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {
                {1,2},
                {2,3}
        };

        System.out.println(sol.isCycle(4, edges));
    }
}