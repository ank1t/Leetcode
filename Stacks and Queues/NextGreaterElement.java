import java.util.*;

class NextGreaterElement {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2)));
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        findNextGreaterElement(nums2, map);

        for(int i = 0;i < nums1.length;i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    void findNextGreaterElement(int[] nums2, HashMap<Integer, Integer> map) {
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = nums2.length - 1; i >= 0;i--) {
            if(stack.isEmpty()) {
                int element = nums2[i];
                map.put(element, -1);
                stack.push(element);
            } else {
                while(!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();
                map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
                stack.push(nums2[i]);
            }
        }
    }
}