import java.util.*;

class Solution {
    ArrayList<ArrayList<int[]>> buildAdjacencyList(int[][] flights, int n) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] flight: flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return adj;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<ArrayList<int[]>> adj = buildAdjacencyList(flights, n);
        //Storing in the form of stops, city, cost
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];

        q.add(new int[]{0, src, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!q.isEmpty()) {
            int[] entry = q.poll();
            int stops = entry[0];
            int node = entry[1];
            int cost = entry[2];

            if(stops > k) continue;
            for(int[] adjV : adj.get(node)) {
                int adjNode = adjV[0];
                int edW = adjV[1];

                if(cost + edW < dist[adjNode]) {
                    dist[adjNode] = cost + edW;
                    q.add(new int[]{stops + 1, adjNode, cost + edW});
                }
            }
        }
        if(dist[dest] == Integer.MAX_VALUE) return -1;
        return dist[dest];
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] flights = new int[][] {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(sol.findCheapestPrice(4, flights, 0, 3, 1));
    }
}