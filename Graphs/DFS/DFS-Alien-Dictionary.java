import java.util.*;

/*
    If in the words array, a longer word appears before a shorter word --> not possible
    Also, if there is a cyclic dependency --> not possible
 */

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, ArrayList<Character>> adj = new HashMap<>();
        Map<Character, Boolean> visited = new HashMap<>();
        Map<Character, Boolean> pathVisited = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for(String word: words) {
            for(char c: word.toCharArray()) {
                visited.putIfAbsent(c, false);
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i = 0;i < words.length - 1;i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";

            for(int ptr = 0;ptr < Math.min(w1.length(), w2.length());ptr++) {
                if(w1.charAt(ptr) != w2.charAt(ptr)) {
                    adj.get(w1.charAt(ptr)).add(w2.charAt(ptr));
                    break;
                }
            }
        }

        for(Character c : adj.keySet()) {
            if(!visited.get(c)) {
                boolean result = dfs(adj, visited, pathVisited, stack, c);
                if(result) return "";
            };
        }

        if(stack.size() < visited.size()) return "";

        String ans = "";
        while(!stack.isEmpty()) {
            ans += (char) stack.pop();
        }

        return ans;
    }

    boolean dfs(Map<Character, ArrayList<Character>> adj,
                Map<Character, Boolean> visited,
                Map<Character, Boolean> pathVisited,
                Stack<Character> stack, Character c) {

        visited.put(c, true);
        pathVisited.put(c, true);

        for(Character adjV: adj.get(c)) {
            if(!visited.get(adjV)) {
                if(dfs(adj, visited, pathVisited, stack, adjV)) return true;
            } else {
                if(pathVisited.get(adjV)) return true;
            }
        }

        pathVisited.put(c, false);
        stack.push(c);
        return false;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"a","b", "a"};
        System.out.println(sol.alienOrder(words));
    }
}