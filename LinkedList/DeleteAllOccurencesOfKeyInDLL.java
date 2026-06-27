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
            Node newHead = new Node(arr[k]);
            temp.next = newHead;
            temp = newHead;
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

    Node deleteAllOccurencesOfKeyInDLL(Node head, int k) {
        Node temp = head;
        Node newHead = null;

        while(temp != null) {
            if(temp.val == k) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
            } else if(newHead == null) newHead = temp;
            temp = temp.next;
        }
        return head;
    }
}
class Scratch {
    public static void main(String[] args) {
    }
}