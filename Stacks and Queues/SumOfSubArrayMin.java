import java.util.Stack;

class SumOfSubArrayMin {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,4,3,2};
        System.out.println(solution.findSumOfSubArrayMin(arr));
    }
}

class Solution {
    int findSumOfSubArrayMin(int[] arr) {
        int sum = 0;
        int mod = (int)(1e9 + 7);
        int[] nse = findNextSmallerElement(arr); //[1,4,4,4]
        int[] psee = findPreviousSmallerOrEqualElement(arr); //[-1,-1,1,2]

        for(int i = 0;i< arr.length;i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            sum = (sum + (left * right * arr[i] % mod)) % mod;
        }
        return sum;
    }

    int[] findNextSmallerElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    int[] findPreviousSmallerOrEqualElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < arr.length;i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
