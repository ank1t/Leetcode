import java.util.*;

class PostfixToPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertPostfixToPrefix("15*2+"));
    }
}

class Solution {
    String convertPostfixToPrefix(String s) {
        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < s.length();i++) {
            Character c = s.charAt(i);
            if(isOperator(c)) {
                var top1 = stack.pop();
                var top2 = stack.pop();
                stack.push(c + top2 + top1);
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