import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return f3(triangle);
    }
    //Triangle of size 4 will have 4 elements in the last list

    //Raw recursion
    int f1(int row, int col, List<List<Integer>> triangle, int n) {
        if(row == n - 1 && col < n) return triangle.get(row).get(col);
        else if(row >= n || col >= row + 1) return Integer.MAX_VALUE;

        int up = triangle.get(row).get(col) + f1(row + 1, col, triangle, n);
        int upLeft = triangle.get(row).get(col) + f1(row + 1, col + 1, triangle, n);

        return  Math.min(up, upLeft);
    }

    /*
        Raw recursion + memoization
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, 10001);
        }
     */
    int f2(int row, int col, List<List<Integer>> triangle, int n, int[][] dp) {
        if(row == n - 1 && col < n) return triangle.get(row).get(col);

        if(dp[row][col] != 10001) return dp[row][col];

        int cur = triangle.get(row).get(col);
        int up = cur + f2(row + 1, col, triangle, n, dp);
        int upLeft = cur + f2(row + 1, col + 1, triangle, n, dp);

        return  dp[row][col] = Math.min(up, upLeft);
    }

    //Tabulation
    int f3(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);

        int n = triangle.size();
        int[] prev = new int[n];
        prev[0] = triangle.get(0).get(0);

        for(int i = 1;i <= n - 1;i++) {
            int[] cur = new int[n];
            Arrays.fill(cur, 10001);
            for(int j = 0;j < i;j++) {
                int down = triangle.get(i).get(j) + prev[j];
                int downRight = triangle.get(i).get(j + 1) + prev[j];

                cur[j] = Math.min(cur[j], down);
                cur[j + 1] = Math.min(cur[j + 1], downRight);
            }
            prev = cur;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++) min = Math.min(min, prev[i]);
        return min;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> list1 = new ArrayList<>(List.of(2));
        List<Integer> list2 = new ArrayList<>(List.of(3,4));
        List<Integer> list3 = new ArrayList<>(List.of(6,5,7));
        List<Integer> list4 = new ArrayList<>(List.of(4,1,8,3));

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(sol.f3(list));
    }
}