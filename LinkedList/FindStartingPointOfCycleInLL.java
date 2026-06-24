
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

        for(int j = 1;j < arr.length;j++) {
            Node newNode = new Node(arr[j]);
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

    /*
        A brute force approach will be to put visited nodes into a map.
        Next begin traversing the LL from head.
        If there exists a loop in the LL, we will visit the node where the cycle begins again, first.

        return this node.
     */
    Node findNodeWhereSlowAndFastPointersMeet(Node head) {
        if(head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return fast;
        }
        return null;
    }

    Node findStartingPointOfCycleInLL(Node head) {
        if(head == null || head.next == null) return null;

        Node fast = findNodeWhereSlowAndFastPointersMeet(head);
        Node slow = head;

        while(fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast == slow ? fast : null;
    }
}
class Scratch {
    public static void main(String[] args) {
        
    }
}