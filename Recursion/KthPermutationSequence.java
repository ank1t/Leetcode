import java.util.*;

class KthPermutationSequence {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        System.out.println(new Solution().findKPermutationSequence(n, k));
    }
}

class Solution {
    public String findKPermutationSequence(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        k = k - 1;
        int fact = 1;

        for(int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i;
        }

        while(!list.isEmpty()) {
            int divisor = (fact/list.size());
            sb.append(Integer.toString(list.get((k / divisor))));
            fact = fact / list.size();
            list.remove((k / divisor));
            k = k % divisor;
        }
        return sb.toString();
    }
}