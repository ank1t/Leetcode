import java.util.Stack;

class BalancedParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfParenthesisAreBalanced("())"));
    }
}

class Solution {
    public boolean checkIfParenthesisAreBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            var currentChar = s.charAt(i);
            if(currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if(stack.isEmpty()) { return false; }
                var poppedChar = stack.pop();
                if (poppedChar == '(' && currentChar != ')') return false;
                else if (poppedChar == '{' && currentChar != '}') return false;
                else if (poppedChar == '[' && currentChar != ']') return false;
            }
        }
        return stack.isEmpty();
    }
}