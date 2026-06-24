
class Node {
    int val;
    Node next;

    Node(int data) {
        val = data;
        next = null;
    }
}

class Solution {
    Node convertArrayToLL(int[] arr){
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

    Node findMiddleOfLL(Node head) {
        if(head == null) return head;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,0,1,1};
        Node head = solution.convertArrayToLL(arr);
        Node middleElement = solution.findMiddleOfLL(head);
        System.out.print("The middle element's value is "+ middleElement.val);
    }
}