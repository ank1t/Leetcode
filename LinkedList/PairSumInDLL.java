import java.util.ArrayList;

class Node {
    int val;
    Node next;
    Node prev;

    Node(int data) {
        val = data;
        next = null;
        prev = null;
    }
}

class Solution {
    Node convertArrayToDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int k = 1;k < arr.length;k++) {
            Node newNode = new Node(arr[k]);
            temp.next = newNode;
            newNode.prev = temp;

            temp = temp.next;
        }
        return head;
    }

    void printDLLFromHeadToTail(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    void printDLLFromTailToHead(Node head) {
        Node temp = head;
        while(temp.next != null) temp = temp.next;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
    }

    ArrayList<ArrayList<Integer>> findPairSum(Node head, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Node tail = head;
        while(tail.next != null) tail = tail.next;

        while(head.val < tail.val) {
            if(head.val + tail.val > sum) tail = tail.prev;
            else if(head.val + tail.val < sum) head = head.next;
            else {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(head.val);
                ans.add(tail.val);
                result.add(ans);
                head = head.next;
                tail = tail.prev;
            }
        }
        return result;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = sol.convertArrayToDLL(arr);
        System.out.print(sol.findPairSum(head, 100));
    }
}