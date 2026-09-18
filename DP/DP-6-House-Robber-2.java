import java.util.*;

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int[] arr = new int[n - 1];
        for(int i = 0;i < n - 1;i++) {
            arr[i] = nums[i];
        }
        int ans1 = findMax(arr);
        for(int i = 1;i < n;i++) {
            arr[i - 1] = nums[i];
        }
        int ans2 = findMax(arr);

        return Math.max(ans1, ans2);
    }

    int findMax(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];

        for(int i = 1;i < nums.length;i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;

            int cur = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{}));
    }
}