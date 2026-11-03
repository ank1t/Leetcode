import java.util.*;

class Solution {
    public int lengthOfLIS(int[] arr) {
        if (arr.length == 1) return 1;
        return solve(arr);
    }

    /*
         multiple piles of cards analogy
         find the first card from the left that is greater than or equal to the incoming element
         Goal is to create piles with larger number at the bottom and smaller number at the top.
         Smaller number at the top increases our chances of forming a larger subsequence later on

         At the end, the number of piles is the length of the LIS
     */
    int solve(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = 1;
        list.add(nums[0]);

        for(int i = 1;i < nums.length;i++) {
            if(nums[i] > list.getLast()) {
                list.add(nums[i]);
                len++;
            } else {
                int insertionIndex = Collections.binarySearch(list, nums[i]);
                insertionIndex = insertionIndex < 0 ? Math.abs(insertionIndex + 1) : insertionIndex;
                list.set(insertionIndex, nums[i]);
            }
        }
        return len;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
    }
}