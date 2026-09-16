import java.util.*;

class DisjointSet {
    ArrayList<Integer> uPar = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int V) {
        for(int i = 0;i <= V;i++) {
            uPar.add(i);
            size.add(1);
        }
    }

    public int getUPar(int node) {
        if (uPar.get(node) == node) return node;
        uPar.set(node, getUPar(uPar.get(node)));
        return uPar.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = getUPar(u);
        int ulp_v = getUPar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)) {
            uPar.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else  {
            uPar.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        ArrayList<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(m * n);
        int[] grid = new int[m * n];
        boolean[] visited = new boolean[m * n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;

        for(int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int index = row * n + col;
            if(!visited[index]) {
                visited[index] = true;
                grid[index] = 1;
                count++;
                for(int[] dir : dirs) {
                    int neighborR = row + dir[0];
                    int neighborC = col + dir[1];
                    int neighborIndex = neighborR * n + neighborC;
                    if (isValid(m, n, neighborR, neighborC) && grid[neighborIndex] == 1 && ds.getUPar(index) != ds.getUPar(neighborIndex)) {
                        ds.unionBySize(index, neighborIndex);
                        count--;
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }

    boolean isValid(int m, int n, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numIslands2(1, 1, new int[][] {{0,0}}));
    }
}