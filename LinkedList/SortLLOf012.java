
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

        for(int k = 1;k<arr.length;k++) {
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

    Node sortLLOf012BruteForce(Node head) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        Node temp = head;
        while(temp != null) {
            if(temp.val == 0) cnt0++;
            else if(temp.val == 1) cnt1++;
            else cnt2++;
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(cnt0 > 0) {
                temp.val = 0;
                cnt0--;
            }
            else if(cnt1 > 0) {
                temp.val = 1;
                cnt1--;
            }
            else {
                temp.val = 2;
                cnt2--;
            }
            temp = temp.next;
        }

        return head;
    }

    Node sortLLOf012Optimized(Node head) {
        return head;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,0,1,2,0,2,1};
        Node head = sol.convertArrayToLinkedList(arr);
        sol.sortLLOf012BruteForce(head);
        sol.printLLFromHeadToTail(head);
    }
}