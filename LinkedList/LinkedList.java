
/*
    LinkedList are used in Stacks and Queues

    Also used in browser. Tab history is managed using LinkedList
    Arrays are stored in a contiguous manner i.e contiguous memory locations on the heap.

    Linked list are not stored in a contiguous memory locations.

    On 32 bit and 64 bit systems, memory space used by int is the same i.e 4 bytes.
    But the memory space used by objects changes. On 32 bit systems, it is 4 bytes and 64 bit systems it is 8 bytes.
 */

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,2,3,4,5,6,7};
        Node head = sol.convertArray2LinkedList(arr);

        //System.out.println(sol.findLengthOfLinkedList(head));
        //System.out.println(sol.findIfElementExistsInLinkedList(head, 6));

//        Node newHead = sol.deleteHeadOfLinkedList(head);
        //sol.printElementsOfLinkedList(newHead);

        //sol.printElementsOfLinkedList(sol.deleteTailOfLinkedList(head));
        //Node newHead = sol.deleteNodeAtPositionInLinkedList(head, 2);
        //sol.printElementsOfLinkedList(newHead);

        //Node newHead = sol.deleteNodeWithValueInLinkedList(head, 2);
        //sol.printElementsOfLinkedList(newHead);

//        Node newHead = sol.insertAtHeadOfLinkedList(head, 11);
//        sol.printElementsOfLinkedList(newHead);

//        Node newHead = sol.insertAtKthPositionInLinkedList(head, 101, 9);
//        sol.printElementsOfLinkedList(newHead);

        Node newHead = sol.insertBeforeValInLinkedList(head, 101, 8);
        sol.printElementsOfLinkedList(newHead);
    }
}

class Solution {
    void printElementsOfLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    Node convertArray2LinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i = 1;i < arr.length;i++) {
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            curr = newNode;
        }
        return head;
    }

    int findLengthOfLinkedList(Node node) {
        int count = 0;
        if(node == null) { return 0; }

        while(node != null) {
            count += 1;
            node = node.next;
        }
        return count;
    }

    boolean findIfElementExistsInLinkedList(Node head, int key) {
        while(head != null) {
            if(head.val == key) { return true; }
            head = head.next;
        }
        return false;
    }

    // Deleting node from LinkedList
    Node deleteHeadOfLinkedList(Node head) {
        return head.next;
    }

    Node deleteTailOfLinkedList(Node head) {
        if(head == null || head.next == null) return null;
        Node prev = head;
        while(prev.next.next != null) {
            prev = prev.next;
        }
        prev.next = null;
        return head;
    }

    //O(k)
    Node deleteNodeAtPositionInLinkedList(Node head, int k) {
        if(head == null) return null;
        else if(k == 1) {
            return head.next;
        }

        int cnt = 1;
        Node temp = head;

        while(temp != null) {
            cnt++;
            if(cnt == k && temp.next != null) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    Node deleteNodeWithValueInLinkedList(Node head, int val) {
        if(head == null) return head;
        else if(head.val == val) return head.next;

        Node temp = head;
        while(temp != null && temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    //Inserting into LinkedList
    Node insertAtHeadOfLinkedList(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        return newNode;
    }

    Node insertAtTailOfLinkedList(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) return newNode;

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    Node insertAtKthPositionInLinkedList(Node head, int val, int k) {
        Node newNode = new Node(val);
        if(head == null) return newNode;
        else if(k == 1) {
            newNode.next = head;
            return newNode;
        }
        int cnt = 1;
        Node temp = head;
        while(temp != null) {
            if(cnt == k - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            cnt++;
            temp = temp.next;
        }

        return head;
    }

    Node insertBeforeValInLinkedList(Node head, int val, int k) {
        Node newNode = new Node(val);
        if(head == null) return null;
        else if(head.val == k) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        while(temp.next != null) {
            if(temp.next.val == k) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}