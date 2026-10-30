import java.util.*;

class Solution {
    public int minInsertions(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();

        return n - recursion(s, t, n - 1, n - 1);
    }

    int recursion(String s, String t, int i, int j) {
        if(i < 0 || j < 0) return 0;

        if(s.charAt(i) == t.charAt(j))
            return 1 + recursion(s, t, i - 1, j - 1);
        else return Math.max(recursion(s, t, i - 1, j),
                recursion(s, t, i, j - 1));
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}