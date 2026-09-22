import java.util.*;

class Solution {
    int minCost(int[][] costs) {
        f(0, 3, costs, costs.length);
    }

    //Plain recursion
    int f(int index, int last, int[][] costs, int m) {
        if(index == m) return 0;

        int min = Integer.MAX_VALUE;
        for(int i = 0;i < 3;i++) {
            if(i != last) {
                min = Math.min(min, costs[index][i] + f(index + 1, i, costs, m));
            }
        }
        return min;
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}