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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> dict = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        ArrayList<ArrayList<String>> emailsByIndex = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0;i < n;i++) {
            List<String> account = accounts.get(i);
            for(int j = 1;j < account.size();j++) {
                String email = account.get(j);
                if(!dict.containsKey(email)) {
                    dict.put(email, i);
                } else {
                    Integer index = dict.get(email);
                    dict.put(email, index);
                    ds.unionBySize(index, i);
                }
            }
        }

        for(int i = 0;i < n;i++) {
            emailsByIndex.add(new ArrayList<>());
        }

        dict.forEach((key, value) -> {
            emailsByIndex.get(ds.getUPar(value)).add(key);
        });

        for(int i = 0;i < n;i++) {
            List<String> emails = emailsByIndex.get(i);
            Collections.sort(emails);
            if(!emails.isEmpty()) {
                emails.add(0, accounts.get(i).get(0));
                ans.add(emails);
            }
        }
        return ans;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.accountsMerge());;
    }
}