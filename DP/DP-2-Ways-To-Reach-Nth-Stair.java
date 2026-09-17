import java.util.*;

class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int prev1 = 2;
        int prev2 = 1;

        for(int i = 3;i <= n;i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(4));
    }
}