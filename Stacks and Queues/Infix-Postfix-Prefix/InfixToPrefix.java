import java.util.*;

class InfixToPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {
          "A+B",
          "A+B-C",
          "A*(B+C)",
          "(A+B)*C",
          "A+B*C",
          "x+y*z/w+u",
          "(a+b)*(c+d)",
          "a+(b*c)",
          "A+B*C^D",
          "(A+B^C)*D+E^5",
        };
        for(String testCase: arr) {
            System.out.println(solution.convertInfixToPrefix(testCase));
        }
    }
}

/*
    Reverse the infix
    InFix 2 Postfix
    Reverse the above answer
 */
class Solution {
    String convertInfixToPrefix(String s) {
        var strSb = new StringBuilder();

        for(int i = s.length() - 1;i >= 0;i--) {
            Character c = s.charAt(i);
            if(c == '(') c = ')';
            else if(c == ')') c = '(';
            strSb.append(c);
        }

        return convertToPostfix(strSb.toString());
    }

    String convertToPostfix(String s) {
        var sb = new StringBuilder();
        var stack = new Stack<Character>();

        for(int i = 0; i < s.length();i++) {
            Character c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(c);
            }
            else if(c == '(') stack.push(c);
            else if(c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
            } else {
                /*
                An element cannot sit on top of an element which has a higher priority in the stack.
                 */
                    if(c != '^') {
                        while(!stack.isEmpty() && priority(c) < priority(stack.peek())) {
                            sb.append(stack.pop());
                        }
                    }
                    else {
                        /*
                        There is no element which has a higher priority than ^. So we check for equality.
                         */
                        while(!stack.isEmpty() && priority(c) == priority(stack.peek())) {
                            sb.append(stack.pop());
                        }
                    }
                    stack.push(c);
                }
            }

        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }

    int priority(Character c) {
        if(c == '^') return 3;
        else if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return -1;
    }
    boolean isOperator(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}