
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

    void printElementsOfLLFromHeadToTail(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    private Node checkIfLoopExistsInLL(Node head) {
        if(head == null) return null;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return slow;
        }
        return null;
    }

    int findLengthOfLoopInLL(Node head) {
        Node nodeWherePointersMeet = checkIfLoopExistsInLL(head);

        if(nodeWherePointersMeet == null) return 0;

        Node temp = nodeWherePointersMeet.next;
        int count = 1;

        while(temp != nodeWherePointersMeet) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
class Scratch {
    public static void main(String[] args) {
        
    }
}