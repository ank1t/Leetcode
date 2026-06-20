
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
        if(head == null || head.next == null) return head;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

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
        Node tail0 = null, tail1 = null, tail2 = null;
        Node head0 = null, head1 = null, head2 = null;

        Node temp = head;
        while(temp != null) {
            if(temp.val == 0) {
                if(head0 == null) {
                    head0 = temp;
                } else {
                    tail0.next = temp;
                }
                tail0 = temp;
            } else if(temp.val == 1) {
                if(head1 == null) {
                    head1 = temp;
                } else {
                    tail1.next = temp;
                }
                tail1 = temp;
            } else {
                if(head2 == null) {
                    head2 = temp;
                } else {
                    tail2.next = temp;
                }
                tail2 = temp;
            }
            temp = temp.next;
        }
        tail0.next = head1;
        tail1.next = head2;
        tail2.next = null;
        return head0;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,0,1,2,0,2,1};
        Node head = sol.convertArrayToLinkedList(arr);
        Node newHead = sol.sortLLOf012Optimized(head);
        sol.printLLFromHeadToTail(newHead);
    }
}