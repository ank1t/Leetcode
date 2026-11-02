import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {

    }

    int recursion(int[] nums, int index, int sIndex) {
        if (index == nums.length) return 0;

        int pick = 0;
        if (sIndex == -1 || nums[index] > nums[sIndex]) {
            pick = 1 + recursion(nums, index + 1, index);
        }
        int notPick = recursion(nums, index + 1, sIndex);
        return Math.max(pick, notPick);
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}