
class Node {
    int val;
    Node next;

    Node(int k){
        val = k;
        next = null;
    }
}

class Solution {
    Node convertArrayToLL(int[] arr) {
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

    Node deleteNThNodeFromEndOfLLBruteForce(Node head, int n) {
        if(head == null || (head.next == null && n == 1) ) return null;

        int count = 0;
        Node temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        if(n == count) return head.next;
        temp = head;
        while(temp.next != null) {
            if(count - n == 1) {
                temp.next = temp.next.next;
                break;
            }
            count--;
            temp = temp.next;
        }
        return head;
    }

    Node deleteNThNodeFromEndOfLLOptimized(Node head, int n) {
    return null;
    }
}
class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        Node head = sol.convertArrayToLL(arr);
        Node newHead = sol.deleteNThNodeFromEndOfLLBruteForce(head,5);
        sol.printLLFromHead(newHead);
    }
}