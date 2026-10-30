import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {

    }

    int recursion(String s, String t, int i, int j) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        int pick = 0;
        if(s.charAt(i) == t.charAt(j))
            pick = recursion(s, t, i + 1, j + 1);
        int notPick = recursion(s, t, i + 1, j);
        return pick + notPick;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}