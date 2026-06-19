
class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
    }
}

class DoublyLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4};
        Node head = sol.convertArrayToDoublyLinkedList(arr);

//        Node newNode = sol.deleteHeadOfDLL(node);
//        System.out.println(newNode.prev);

//        sol.deleteTailOfDLL(node);
//        sol.printLinkedListElementsStartingFromHead(node)

//        sol.printLinkedListElementsStartingFromHead(sol.deleteKthNodeinDLL(node, 8));
//        sol.deleteNodeInDLL(head.next.next.next.next.next.next);
//        sol.printLinkedListElementsStartingFromHead(head);

        sol.printLinkedListElementsStartingFromHead(sol.insertBeforeKthPositionInLinkedList(head, 101, 5));
    }
}

class Solution {
    void printLinkedListElementsStartingFromHead(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val);
            System.out.print(" ");
            temp = temp.next;
        }
    }

    void printLinkedListElementsStartingFromTail(Node tail) {
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.val);
            System.out.print(" ");
            temp = temp.prev;
        }
    }

    Node convertArrayToDoublyLinkedList(int[] arr) {
        Node head = new Node(arr[0]);

        Node prev = head;
        for(int k = 1;k < arr.length;k++) {
            Node newNode = new Node(arr[k]);
            prev.next = newNode;
            newNode.prev = prev;
            prev = newNode;
        }
        return head;
    }

    //Deletion of nodes from Doubly Linked List
    Node deleteHeadOfDLL(Node head) {
        if(head == null || head.next == null) return null;
        head.next.prev = null;
        return head.next;
    }

    Node deleteTailOfDLL(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
        return head;
    }

    Node deleteKthNodeinDLL(Node head, int k) {
        if(head == null || head.next == null) return null;
        if(k == 1) {
            Node curr = head.next;
            head.next.prev = null;
            head.next = null;
            return curr;
        }
        Node curr = head;
        int count = 1;

        while(curr != null) {
            if(count == k) {
                curr.prev.next = curr.next;
                if(curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                break;
            }
            count++;
            curr = curr.next;
        }
        return head;
    }

    void deleteNodeInDLL(Node node) {
        node.prev.next = node.next;
        if(node.next != null) {
            node.next.prev = node.prev;
        }
    }

    //Insertion of nodes in Doubly Linked List
    Node insertBeforeHeadInDoublyLinkedList(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) return newNode;

        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    Node insertBeforeTailInDoublyLinkedList(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) return newNode;
        else if (head.next == null) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        temp.prev.next = newNode;
        newNode.prev = temp.prev;
        temp.prev = newNode;
        newNode.next = temp;
        return head;
    }

    Node insertBeforeKthPositionInLinkedList(Node head, int val, int k) {
        Node newNode = new Node(val);
        if(k == 1) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        int count  = 1;
        Node temp = head;
        while(temp != null) {
            if(count == k) {
                temp.prev.next = newNode;
                newNode.prev = temp.prev;
                newNode.next = temp;
                temp.prev = newNode;
                break;
            }
            count++;
            temp = temp.next;
        }
        return head;
    }

    void insertBeforeNode(Node node, int val) {
        Node newNode = new Node(val);
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev.next = newNode;
        node.prev = newNode;
    }
}