import java.util.*;

class Solution {
    int row, col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights.length;
        Queue<> q = new LinkedList<>();

    }
}

class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        System.out.println(sol.pacificAtlantic(heights));
    }
}