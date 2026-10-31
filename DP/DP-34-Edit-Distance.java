import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return recursion(word1, word2, n - 1, m - 1);
    }

    int recursion(String s, String t, int i, int j) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(s.charAt(i) == t.charAt(j)) return recursion(s, t, i - 1, j - 1);
        else {
            int replace = 1 + recursion(s, t, i - 1, j - 1);
            int insert = 1 + recursion(s, t, i, j - 1);
            int delete = 1 + recursion(s, t, i - 1, j);

            return Math.min(Math.min(replace, insert), delete);
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}