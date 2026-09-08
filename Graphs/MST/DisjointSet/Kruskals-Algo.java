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

    public void unionByRank(int u, int v) {
        int ulp_u = getUPar(u);
        int ulp_v = getUPar(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            uPar.set(ulp_u, ulp_v);
        } else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            uPar.set(ulp_v, ulp_u);
        } else {
            uPar.set(ulp_u, ulp_v);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
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

class Edge implements Comparable<Edge> {
    int to;
    int from;
    int wt;

    Edge(int _to, int _from, int _wt) {
        this.to = _to;
        this.from = _from;
        this.wt = _wt;
    }

    @Override
    public int compareTo(Edge pair) {
        return Integer.compare(this.wt, pair.wt);
    }
}

class Solution {
    public int spanningTree(int V, int[][] e) {
        ArrayList<Edge> edges = new ArrayList<>();

        for(int[] edge : e) {
            edges.add(new Edge(edge[0], edge[1], edge[2]));
        }

        DisjointSet set = new DisjointSet(V);
        Collections.sort(edges);
        int mstWt = 0;

        for(Edge edge : edges) {
            if(set.getUPar(edge.to) != set.getUPar(edge.from)) {
                set.unionBySize(edge.to, edge.from);
                mstWt += edge.wt;
            }
        }
        return mstWt;
    }
}
