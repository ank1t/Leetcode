import java.util.Stack;
import static java.lang.Math.abs;

class AstroidCollision {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,7,1,1,2,-3,-7,17,15,-16};
        solution.findFinalStateAfterAstroidCollision(arr);
    }
}

class Solution {
    void findFinalStateAfterAstroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i = 0;i < arr.length;i++) {
            if((stack.peek() > 0 && arr[i] > 0) || (stack.peek() < 0 && arr[i] < 0)) stack.push(arr[i]);
            else {
                while(!stack.isEmpty() && abs(stack.peek()) <= abs(arr[i])) {
                    stack.pop();
                    if(!stack.isEmpty() && abs(stack.peek()) == abs(arr[i])) break;
                }
                if(stack.isEmpty()) stack.push(arr[i]);
            }
        }

        System.out.println(stack);
    }
}