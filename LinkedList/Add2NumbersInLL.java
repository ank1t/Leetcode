
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

    /*
    Whenever there is a need to create a new node, prefer the concept of dummy node;
     */
    Node addNumbersInLL(Node head1, Node head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;

        int carry = 0;
        Node ans = new Node(-1);
        Node temp = ans;

        while(head1 != null || head2 != null) {
            int sum = carry;
            if(head1 != null) sum += head1.val;
            if(head2 != null) sum += head2.val;
            carry = sum/10;
            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = newNode;
            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }

//        while(head1 != null) {
//            int sum = carry + head1.val;
//            carry = sum/10;
//            Node newNode = new Node(sum % 10);
//            temp.next = newNode;
//            temp = newNode;
//            head1 = head1.next;
//        }
//
//        while(head2 != null) {
//            int sum = carry + head2.val;
//            carry = sum/10;
//            Node newNode = new Node(sum % 10);
//            temp.next = newNode;
//            temp = newNode;
//            head2 = head2.next;
//        }

        if(carry != 0) {
            temp.next = new Node(carry);
        }

        return ans.next;
    }

    void printElementsOfLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {4,5,9,9};
        int[] arr2 = {3,5};

        Node head1 = sol.convertArrayToLinkedList(arr1);
        Node head2 = sol.convertArrayToLinkedList(arr2);

        Node ans = sol.addNumbersInLL(head1, head2);
        sol.printElementsOfLL(ans);
    }
}