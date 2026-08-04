import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        return mat;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(Arrays.deepToString(sol.updateMatrix(mat)));
    }
}