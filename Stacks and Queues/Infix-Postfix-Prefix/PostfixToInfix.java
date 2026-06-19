import java.util.*;

class PostfixToInfix {
    public static void main(String[] args) {
        var solution = new Solution();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("A B +", "(A + B)");
        map.put("A B * C +", "((A * B) + C)");
        map.put("A B + C *", "(A + B) * C");
        map.put("A B C * + D /", "((A + (B * C)) / D)");
        map.put("W X Y Z - + *", "(W * (X + (Y - Z)))");
        map.put("A B + C D + *", "((A + B) * (C + D))");
        map.put("A B * C D * +", "((A * B) + (C * D))");
        map.put("2 3 + 5 - 8 *", "(((2 + 3) - 5) * 8)");

        map.forEach((key, value) ->
                System.out.println(solution.convertPostfixToInfix(key).equals(value) ? true : key + "---" + solution.convertPostfixToInfix(key))
        );
    }
}

class Solution {
    String convertPostfixToInfix(String s) {
        Stack<String> stack = new Stack<>();

        for(int i = 0;i < s.length();i++) {
            Character c = s.charAt(i);
            if(c.equals(' ')) continue;
            if(isOperator(c)) {
                var top1 = stack.pop();
                var top2 = stack.pop();
                stack.push("(" + top2 + " " + c + " " + top1 + ")");
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