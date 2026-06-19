import java.util.Arrays;
import java.util.Stack;
import java.util.Arrays;

class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(solution.getMostAmtOfRainWaterTrapped(nums));
    }
}

/*
   This can be solved using prefix max and suffix max. Such an approach will require O(2N) space.
   Formula to use if min(lmax, rmax) - arr[i]
 */

class Solution {
    int getMostAmtOfRainWaterTrapped(int[] arr) {
        int lmax = 0;
        int rmax = 0;
        int l = 0;
        int r = arr.length - 1;
        int ans = 0;
        while(l < r) {
            if(arr[l] <= arr[r]) {
                if(arr[l] > lmax) lmax = arr[l];
                else ans += (lmax - arr[l]);
                l++;
            } else {
                if(arr[r] > rmax) rmax = arr[r];
                else ans += (rmax - arr[r]);
                r--;
            }
        }

        return ans;
    }
}