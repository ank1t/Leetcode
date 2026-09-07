import java.util.*;

class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> uPar = new ArrayList<>();

    DisjointSet(int V) {
        for(int i = 0;i < V;i++) {
            uPar.add(i);
            rank.add(0);
        }
    }

    public int getUPar(int node) {
        if(uPar.get(node) == node) return node;
        uPar.set(node, uPar.get(node));
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
}

class Scratch {
    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(8);
        set.unionByRank(1,2);
        set.unionByRank(2,3);
        set.unionByRank(4,5);
        set.unionByRank(6,7);
        set.unionByRank(5,6);

        if(set.getUPar(3) == set.getUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        set.unionByRank(3,7);
        if(set.getUPar(3) == set.getUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }
}