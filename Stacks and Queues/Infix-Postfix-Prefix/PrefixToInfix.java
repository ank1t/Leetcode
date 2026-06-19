import java.util.*;

class PrefixToInfix {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertPrefixToInfix(""));
    }
}

class Solution {
    String convertPrefixToInfix(String s) {
        Stack<String> stack = new Stack<>();

        for(int i = s.length() - 1;i >= 0;i--) {
            Character c = s.charAt(i);
            if(isOperator(c)) {
                var top1 = stack.pop();
                var top2 = stack.pop();
                stack.push("(" + top1 + " " + c + " " + top2 + ")");
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