import java.util.*;

class Solution {
    ArrayList<Integer> bellmanFord(int n, int[][] edges, int src) {
        ArrayList<Integer> dist = new ArrayList<>(n);
        int tenToPower8 = 1_000_000_00;
        for(int i = 0;i < n;i++) {
            dist.add(i, tenToPower8);
        }
        dist.set(src, 0);

        for(int i = 1;i <= n;i++) {
            for(int[] edge: edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist.get(u) != tenToPower8 && dist.get(u) + wt < dist.get(v)) {
                    if(i == n) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(-1);
                        return list;
                    }
                    dist.set(v, dist.get(u) + wt);
                }
            }
        }
        return dist;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 =  {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        System.out.println(Arrays.toString(sol.getShortestDistToEachNode(5, edges1, 0)));;

        int[][] edges2 =   {{0, 1, 4}, {1, 2, -6}, {2, 3, 5}, {3, 1, -2}};
        System.out.println(Arrays.toString(sol.getShortestDistToEachNode(4, edges2, 0)));;
    }
}