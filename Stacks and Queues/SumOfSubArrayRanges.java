import java.util.Stack;

class SumOfSubArrayRanges {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,4,3,2};
        System.out.println(solution.findSumOfSubArrayRanges(arr));
    }
}

class Solution {
    int findSumOfSubArrayRanges(int[] arr) {
        int[] nse = findNextSmallerElementIndex(arr);
        int[] psee = findPreviousSmallerOrEqualElementIndex(arr);
        int[] nge = findNextGreaterElementIndex(arr);
        int[] pgee = findPreviousGreaterOrEqualElementIndex(arr);

        int sumMin = 0;
        int sumMax = 0;

        for(int i = 0;i < arr.length;i++) {
            int lmin = i - psee[i];
            int rmin = nse[i] - i;
            sumMin = sumMin + lmin * rmin * arr[i];

            int lmax = i - pgee[i];
            int rmax = nge[i] - i;
            sumMax = sumMax + lmax * rmax * arr[i];
        }
        return sumMax - sumMin;
    }

    int[] findNextSmallerElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1;i >= 0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    int[] findPreviousSmallerOrEqualElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < arr.length;i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    int[] findNextGreaterElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1;i >= 0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    int[] findPreviousGreaterOrEqualElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < arr.length;i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }
}