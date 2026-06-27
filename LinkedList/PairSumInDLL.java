
class Node {
    int val;
    Node next;
    Node prev;

    Node(int data) {
        val = data;
        next = null;
        prev = null;
    }
}

class Solution {
    Node convertArrayToDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int k = 1;k < arr.length;k++) {
            Node newNode = new Node(arr[k]);
            temp.next = newNode;
            newNode.prev = temp;

            temp = temp.next;
        }
        return head;
    }

    void printDLLFromHeadToTail(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    void printDLLFromTailToHead(Node head) {
        Node temp = head;
        while(temp.next != null) temp = temp.next;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        Node head = sol.convertArrayToDLL(arr);
//        sol.printDLLFromHeadToTail(head);
        sol.printDLLFromTailToHead(head);
    }
}