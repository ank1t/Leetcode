import java.util.*;

class Solution {
    //Plain recursive solution - Using Top down approach
    int f1(int i, int j) {
        if(i == 0 && j == 0) return 1;
        else if(i < 0 || j < 0) return 0;

        int up = f1(i - 1, j);
        int left = f1(i, j - 1);

        return up + left;
    }

    //Plain recursive solution using bottom up
    int f2(int i, int j, int m, int n) {
        if(i == m - 1 && j == n - 1) return 1;
        else if(i < 0 || j < 0) return 0;

        int down = f2(i + 1, j, m, n);
        int right = f2(i, j + 1, m ,n);

        return down + right;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}