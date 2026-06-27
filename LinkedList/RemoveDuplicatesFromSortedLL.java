
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

    Node removeDuplicatesFromLL(Node head) {
        if(head == null || head.next == null) return head;
        int prevVal = head.val;
        Node prevUniqueNode = head;
        Node temp = head;

        while(temp != null) {
            if(temp.val != prevVal) {
                prevVal = temp.val;
                prevUniqueNode.next = temp;
                prevUniqueNode = temp;
            }
            temp = temp.next;
        }
        prevUniqueNode.next = null;
        return head;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,1,2,2,3,3,3,3,3,3,4,4,4,4};
        Node head = sol.convertArrayToLL(arr);
        sol.removeDuplicatesFromLL(head);
        sol.printLLFromHeadToTail(head);
    }
}