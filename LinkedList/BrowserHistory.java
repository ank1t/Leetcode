class BrowserHistory {

    public BrowserHistory(String homepage) {

    }

    public void visit(String url) {

    }

    public String back(int steps) {

    }

    public String forward(int steps) {

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

    }
}