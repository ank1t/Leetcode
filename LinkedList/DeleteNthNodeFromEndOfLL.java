
class Node {
    int val;
    Node next;

    Node(int k){
        val = k;
        next = null;
    }
}

class Solution {
    Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int k = 1;k<arr.length;k++) {
            Node newNode = new Node(arr[k]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    void printLLFromHead(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    Node deleteNThNodeFromEndOfLL(Node head, int n) {

    }
}
class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        Node head = sol.convertArrayToLL(arr);
        sol.printLLFromHead(head);
    }
}