
class Node {
    int val;
    Node next;

    Node(int data) {
        val = data;
        next = null;
    }
}

class Solution {
    Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int l = 1;l < arr.length;l++) {
            Node newNode = new Node(arr[l]);
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

    Node deleteMiddleNodeOfLL(Node head) {
        if(head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        fast = fast.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
class Scratch {
    public static void main(String[] args) {
        
    }
}