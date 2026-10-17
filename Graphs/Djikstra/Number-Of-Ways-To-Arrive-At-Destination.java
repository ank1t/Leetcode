import java.util.*;

class Pair {
    int city;
    int time;

    Pair(int city, int time) {
        this.city = city;
        this.time = time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int[] dist = new int[n];
        int[] ways = new int[n];
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b) -> a.time - b.time);
        int MOD = 1_000_000_007;
        ArrayList<ArrayList<Pair>> adj = buildAdjList(n, roads);

        q.add(new Pair(0, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;

        while(!q.isEmpty()) {
            Pair pair = q.poll();

            for(Pair adjPair : adj.get(pair.city)) {
                if(dist[adjPair.city] < dist[pair.city] + adjPair.time) continue;

                if(dist[adjPair.city] > dist[pair.city] + adjPair.time) {
                    dist[adjPair.city] = dist[pair.city] + adjPair.time;
                    if(adjPair.city == n - 1) count = 1;
                    q.add(new Pair(adjPair.city, dist[pair.city] + adjPair.time));
                } else if(adjPair.city == n - 1) count++;
            }
        }

        return ways[n - 1] % MOD;
    }

    ArrayList<ArrayList<Pair>> buildAdjList(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] road: roads) {
            int city1 = road[0];
            int city2 = road[1];
            int time = road[2];

            adj.get(city1).add(new Pair(city2, time));
        }
        return adj;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(sol.countPaths(7, roads));
    }
}