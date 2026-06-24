import java.util.Stack;

class Node {
    int val;
    Node next;

    Node(int data) {
        val = data;
        next = null;
    }
}

class Solution {
    Node convertArrayToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int k = 1;k< arr.length;k++) {
            Node newNode = new Node(arr[k]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    void printLLFromHeadToTail(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    boolean checkIfLLIsPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.val != stack.pop()) return false;
            temp = temp.next;
        }
        return true;
    }
}
class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,2,0};
        Node head = sol.convertArrayToLL(arr);
        System.out.print(sol.checkIfLLIsPalindrome(head));
    }
}