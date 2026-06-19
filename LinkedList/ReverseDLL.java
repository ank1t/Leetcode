import java.util.Stack;

class Node {
    int val;
    Node prev;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class Solution {
    Node convertArrayToDLL(int[] arr) {
        Node head = new Node(arr[0]);

        Node temp = head;
        for(int k = 1;k < arr.length;k++) {
            Node newNode = new Node(arr[k]);
            newNode.prev = temp;
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    void printElementsOfDLLFromHeadToTail(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    void printElementsOfDLLFromTailToHead(Node tail) {
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
    }

    Node reverseDLL(Node head) {
        Node curr = head;
        while(curr != null) {
            Node temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            if(curr.prev != null) {
                curr = curr.prev;
            } else break;
        }
        return curr;
    }

    Node reverseDLLUsingStack(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        while(!stack.isEmpty()) {
            Node newNode = new Node(stack.pop());
            newNode.prev = temp;
            if(temp != null) temp.next = newNode;
            temp = newNode;
        }

        return temp;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        Node head = sol.convertArrayToDLL(arr);
//        sol.printElementsOfDLLFromHeadToTail(head);

        Node tail = sol.reverseDLL(head);
        sol.printElementsOfDLLFromHeadToTail(tail);
    }
}