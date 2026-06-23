
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

        for(int k = 1;k < arr.length;k++) {
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

    Node reverseLL(Node head) {
        if(head == null) return null;

        Node runner = head;
        Node prev = null;

        while(runner != null) {
            Node next = runner.next;
            runner.next = prev;
            prev = runner;
            runner = next;
        }
        return prev;
    }
}
class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5};
        Node head = sol.convertArrayToLL(arr);
        Node newNode = sol.reverseLL(head);
        sol.printLLFromHeadToTail(newNode);
    }
}