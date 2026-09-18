import java.util.*;

/*
    Also called Stickler thief problem - loot houses but cannot loot adjacent houses.
    Maximize loot
 */
class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        return dp(n - 1, arr);
    }

    private int dp(int index, int[] arr) {
        if(index == 0) return arr[0];
        if(index < 0) return 0;

        int pick = arr[index] + dp(index - 2, arr);
        int notpick = dp(index - 1, arr);

        return Math.max(pick, notpick);
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxSum());
    }
}