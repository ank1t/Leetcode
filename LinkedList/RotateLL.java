
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

    Node rotateLL(Node head, int rIndex) {
        if(head == null || head.next == null) return head;

        int count = 1;
        Node temp = head;

        while(temp.next != null) {
            count++;
            temp = temp.next;
        }
        if(rIndex % count == 0) return head;
        temp.next = head;
        rIndex = rIndex % count;
        int newCount = 0;
        temp = head;

        while(temp != null) {
            newCount++;
            if(count - newCount == rIndex) {
                Node t = temp.next;
                temp.next = null;
                return t;
            }
            temp = temp.next;
        }
        return null;
    }
}
class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7};
        Node head = sol.convertArrayToLL(arr);
        Node newHead = sol.rotateLL(head, 8);
        sol.printLLFromHeadToTail(newHead);
    }
}