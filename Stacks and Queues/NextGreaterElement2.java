import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 10, 12, 1, 11};
        System.out.println(Arrays.toString(solution.findNextGreaterElement(arr)));
    }
}

class Solution {
    int[] findNextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2 * n - 1; i >= 0;i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if(i <= n - 1) {
                ans[i] = !stack.isEmpty() ? stack.peek() : -1;
            }
            stack.push(nums[i % n]);
        }
        return ans;
    }
}