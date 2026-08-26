import java.util.*;

/*
    If in the words array, a longer word appears before a shorter word --> not possible
    Also, if there is a cyclic dependency --> not possible
 */

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, ArrayList<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word: words) {
            for(char c: word.toCharArray()) {
                indegree.put(c, 0);
                adj.putIf(c, new ArrayList<>());
            }
        }

        for(int i = 0;i < words.length - 1;i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";
            int len = Math.min(w1.length(), w2.length());

            for(int ptr = 0;ptr < len;ptr++) {
                if(w1.charAt(ptr) != w2.charAt(ptr)) {
                    adj.get(w1.charAt(ptr)).add(w2.charAt(ptr));
                    indegree.put(w2.charAt(ptr), indegree.get(w2.charAt(ptr)) + 1);
                    break;
                }
            }
        }

        String ans = "";
        Queue<Character> q = new LinkedList<>();
        for(Character c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                q.add(c);
            }
        }

        while(!q.isEmpty()) {
            Character c = q.poll();
            ans += c;
            for(Character adjC: adj.get(c)) {
                indegree.put(adjC, indegree.get(adjC) - 1);
                if(indegree.get(adjC) == 0) q.add(adjC);
            }
        }

        if(ans.length() < indegree.size()) return "";

        return ans;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"z", "z"};
        System.out.println(sol.alienOrder(words));
    }
}