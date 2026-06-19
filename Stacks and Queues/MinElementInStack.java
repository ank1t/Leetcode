import java.util.Stack;

class MinElementInStack {
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(12);
        minStack.push(15);
        minStack.push(10);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.push(10);
        System.out.println(minStack.top());
    }
}

class MinStack {
    private Stack<Tuple> stack = new Stack<>();

    void push(int num) {
        var min = stack.isEmpty() ? num : Math.min(stack.peek().min, num);
        var tuple = new Tuple(num, min);
        stack.push(tuple);
    }

    int pop() {
        return stack.pop().val;
    }

    int top() {
        return stack.peek().val;
    }

    int size() {
        return stack.size();
    }

    int getMin() {
        return stack.peek().min;
    }

}

class Tuple {
    int val;
    int min;

    public Tuple(int num, int i) {
        val = num;
        min = i;
    }
}

class MinStack2 {
    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    void push(int val) {
        //2 * val - min
        if(!stack.isEmpty()) {
            if(val < min) {
                stack.push(2 * val - min);
                min = val;
            } else { stack.push(val); }
        } else {
            stack.push(val);
            min = val;
        }
    }

    int pop() {
        if(!stack.isEmpty()) {
            if (stack.peek() < min) {
                int temp = min;
                min = 2 * min - stack.pop();
                return temp;
            }
            return stack.pop();
        }
        return -1;
    }

    int size() {
        return stack.size();
    }

    int getMin() {
        return min;
    }

    int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek() < min ? min : stack.peek();
    }
}