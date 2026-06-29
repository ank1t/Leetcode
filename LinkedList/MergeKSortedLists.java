import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    Node next;
    int val;

    Node(int data) {
        val = data;
        next = null;
    }
}

class Solution {
    record Tuple(int val, Node node) { }

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
        while(temp  != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    Node mergeKSortedLists(Node[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        PriorityQueue<Tuple> pq = new PriorityQueue<>(
            Comparator.comparingInt(Tuple::val)
        );

        for(int k = 0;k < lists.length;k++) {
            if(lists[k] != null) {
                Tuple tuple = new Tuple(lists[k].val, lists[k]);
                pq.add(tuple);
            }
        }

        Node dummyHead = new Node(-1);
        Node temp = dummyHead;

        while(!pq.isEmpty()) {
            Tuple minElement = pq.poll();
            temp.next = minElement.node;
            temp = minElement.node;

            if(minElement.node.next != null) {
                Tuple tuple = new Tuple(minElement.node.next.val, minElement.node.next);
                pq.add(tuple);
            }
        }
        return dummyHead.next;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        Node head = sol.convertArrayToLL(arr);
        sol.printLLFromHeadToTail(head);
    }
}