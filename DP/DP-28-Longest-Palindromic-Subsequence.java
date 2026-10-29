import java.util.*;

class Solution {
    public int longestPalindromeSubseq(String s) {
        return recursion(s, new StringBuilder(s).reverse().toString(),
                s.length() - 1, s.length() - 1);
    }

    int recursion(String s, String t, int i, int j) {
        if(i < 0 || j < 0) return 0;

        if(s.charAt(i) == t.charAt(j))
            return 1 + recursion(s, t, i - 1, j - 1);
        else return Math.max(recursion(s, t, i - 1, j),
                                recursion(s, t, i, j - 1));

    }

    int tabulation(String s, String t, int i, int j, int[][] dp) {

    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}