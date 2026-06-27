
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

    Node merge2SortedLLs(Node head1, Node head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;

        Node temp1 = head1;
        Node temp2 = head2;
        Node head = new Node(-1);
        Node temp = head;

        while(temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        temp.next = temp1 == null ? temp2 : temp1;
        return head.next;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,5,9};
        int[] arr2 = {4,8,7};

        Node head1 = sol.convertArrayToLL(arr1);
        Node head2 = sol.convertArrayToLL(arr2);

        Node head = sol.merge2SortedLLs(head1, head2);
        sol.printLLFromHeadToTail(head);
    }
}