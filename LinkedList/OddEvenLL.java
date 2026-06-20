
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class Solution {
    Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int k = 1;k < arr.length;k++) {
            temp.next = new Node(arr[k]);
            temp = temp.next;
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
    /*
        Very important to remember: Even pointer will always be ahead of odd.
        So all checks can be built around just the even pointer.
     */
    Node convertToOddEvenLL(Node head) {
        if(head == null || head.next == null) return head;
        Node firstEven = head.next;

        Node odd = head;
        Node even = head.next;

        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = firstEven;
        return head;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6};
        Node head = sol.convertArrayToLinkedList(arr);
        sol.convertToOddEvenLL(head);
        sol.printLLFromHead(head);

    }
}