import java.util.Stack;
import java.util.HashMap;

class InfixToPostfix {
    public static void main(String[] args) {
        var map = new HashMap<Character, Integer>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        Solution solution = new Solution();
        System.out.println(solution.convertInfixToPostfix("a+b*(c^d-e)", map));
    }
}

/*
    Infix = a + b * (c ^ d - e)
    Postfix = a b c d ^ e - * +
 */
class Solution {
    String convertInfixToPostfix(String s, HashMap<Character, Integer> map) {
        var stack = new Stack<Character>();
        var sb = new StringBuilder();

        for(int i = 0;i < s.length();i++) {
            var character = s.charAt(i);
            if(Character.isLetter(character) || Character.isDigit(character)) {
                sb.append(character);
            } else {
                if(isOperator(character, map)) {
                    while(!stack.isEmpty() && map.get(character) <= map.getOrDefault(stack.peek(), -1)) {
                        sb.append(stack.pop());
                    }
                    stack.push(character);
                } else {
                    if(character == '(') {
                        stack.push(character);
                    } else {
                        while(!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
    private boolean isOperator(Character character, HashMap<Character, Integer> map) {
        return map.containsKey(character);
    }
}