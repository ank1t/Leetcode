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

class Scratch {
    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(7);
        set.unionBySize(1,2);
        set.unionBySize(2,3);
        set.unionBySize(4,5);
        set.unionBySize(6,7);
        set.unionBySize(5,6);

        if(set.getUPar(3) == set.getUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        set.unionBySize(3,7);
        if(set.getUPar(3) == set.getUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }
}