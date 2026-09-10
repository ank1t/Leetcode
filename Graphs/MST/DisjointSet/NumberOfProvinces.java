import java.util.*;

class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> uPar = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int V) {
        for(int i = 0;i <= V;i++) {
            uPar.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int getUPar(int node) {
        if(uPar.get(node) == node) return node;
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
    public int findCircleNum(int[][] mat) {
        int n = mat[0].length;
        int count = 0;
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(mat[i][j] == 1) ds.unionBySize(i, j);
            }
        }

        for(int i = 0;i < n;i++) {
            if(ds.uPar.get(i) == i) count++;
        }
        return count;
    }
}