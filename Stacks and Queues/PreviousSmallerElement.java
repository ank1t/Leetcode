import java.util.Stack;
import java.util.Arrays;

class PreviousSmallerElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(solution.findPreviousSmallerElement(arr)));
    }
}

class Solution {
    int[] findPreviousSmallerElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < n + 2;i++) {
            while(!stack.isEmpty() && stack.peek() >= nums[i % n]) stack.pop();
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return ans;
    }
}