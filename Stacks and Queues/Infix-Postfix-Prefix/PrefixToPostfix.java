import java.util.*;

class PrefixToPostfix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertPrefixToPostfix("-+A*BC/DE"));
    }
}

class Solution {
    String convertPrefixToPostfix(String s) {
        Stack<String> stack = new Stack<>();

        for(int i = s.length() - 1;i >= 0;i--) {
            Character c = s.charAt(i);
            if(isOperator(c)) {
                var top1 = stack.pop();
                var top2 = stack.pop();
                stack.push(top1 + top2 + c);
            } else {
                stack.push(c+"");
            }
        }
        return stack.pop();
    }

    boolean isOperator(Character c) {
        return c == '*' || c == '/' || c == '+' || c == '-' || c == '^';
    }
}