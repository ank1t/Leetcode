class BrowserHistory {

    private Node list;
    private Node currNode;

    public BrowserHistory(String homepage) {
        Node home = new Node(homepage);
        currNode = home;
        list = home;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        currNode.next = newNode;
        newNode.prev = currNode;
        currNode = newNode;
    }

    public String back(int steps) {
        while(currNode.prev != null && steps > 0) {
            currNode = currNode.prev;
            steps--;
        }
        return currNode.data;
    }

    public String forward(int steps) {
        while(currNode.next != null && steps > 0) {
            currNode = currNode.next;
            steps--;
        }
        return currNode.data;
    }
}

class Node {
    String data;
    Node next;
    Node prev;

    Node(String url) {
        data = url;
        next = null;
        prev = null;
    }
}

class Scratch {
    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("google.com");
        obj.visit("ig");
        obj.visit("fb");
        obj.visit("yt");
        obj.visit("pinterest");
        obj.visit("reddit.com");
        System.out.println(obj.back(4));
        System.out.println(obj.forward(4));
        obj.visit("wiki");
        System.out.println(obj.back(1));
    }
}