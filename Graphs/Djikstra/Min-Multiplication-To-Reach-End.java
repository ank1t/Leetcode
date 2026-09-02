import java.util.*;


class Pair {
    int num;
    int count;

    Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if(start == end) return 0;
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[1000];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Pair firstPair = new Pair(start, 0);
        q.add(firstPair);
        dist[start] = 0;

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            for(int multiplier : arr) {
                int product = (pair.num * multiplier) % 1000;
                if(product == end) return pair.count + 1;

                if(dist[product] > pair.count + 1) {
                    dist[product] = pair.count + 1;
                    q.add(new Pair(product, pair.count + 1));
                }
            }

        }

        return -1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minSteps(new int[]{2,5,7}, 3, 30));
    }
}