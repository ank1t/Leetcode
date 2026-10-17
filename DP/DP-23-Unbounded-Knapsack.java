import java.util.*;

//https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {

        return recursion(val, wt, capacity, wt.length - 1);
    }

    int recursion(int[] val, int[] wt, int capacity, int index) {
        if(index == 0) {
            if(wt[0] <= capacity) return capacity/wt[0];
            return 0;
        }

        int notTake = recursion(val, wt, capacity, index  - 1);
        int take = 0;
        if(wt[index] <= capacity) take = val[index] + recursion(val, wt, capacity - wt[index], index);

        return Math.max(notTake, take);
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}