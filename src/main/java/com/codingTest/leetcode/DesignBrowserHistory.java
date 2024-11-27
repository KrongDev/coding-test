package com.codingTest.leetcode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DesignBrowserHistory {

    public class Node{
        String url;
        Node prev;
        Node next;

        public Node(String url, Node prev) {
            this.url = url;
            this.prev = prev;
        }

        public Node visit(String url) {
            if(this.next != null) {
                this.next.prev = null;
                this.next = null;
            }
            Node newNode = new Node(url, this);
            this.next = newNode;
            return newNode;
        }

        public Node back() {
            return this.prev != null ? this.prev : this;
        }

        public Node forward() {
            return this.next != null ? this.next : this;
        }

        public boolean isNextEmpty() {
            return this.next == null;
        }

        public boolean isPrevEmpty() {
            return this.prev == null;
        }
    }

    public Node current;

    public DesignBrowserHistory(String homepage) {
        this.current = new Node(homepage, null);
    }

    public void visit(String url) {
        this.current = this.current.visit(url);
    }

    public String back(int steps) {

        while(!this.current.isPrevEmpty() && steps-- > 0) {
            this.current = this.current.back();
        }
        return this.getCurrent();
    }

    public String forward(int steps) {
        while (!this.current.isNextEmpty() && steps-- > 0) {
            this.current = this.current.forward();
        }
        return this.getCurrent();
    }

    private String getCurrent() {
        return this.current == null ? null : this.current.url;
    }

    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] command = {"BrowserHistory", "visit", "visit", "visit", "back", "back", "forward", "visit", "forward", "back", "back"};
        Object[][] data = {{"leetcode.com"}, {"google.com"}, {"facebook.com"}, {"youtube.com"}, {1}, {1}, {1}, {"linkedin.com"}, {2}, {2}, {7}};
        int len = command.length;

        DesignBrowserHistory res = new DesignBrowserHistory((String) data[0][0]);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("null, ");
        for (int i = 1; i < len; i++) {
            Object d = data[i][0];
            switch (command[i]) {
                case "visit":
                    res.visit(String.valueOf(d));
                    sb.append("null");
                    break;
                case "back":
                    sb.append(res.back((int) d));
                    break;
                case "forward":
                    sb.append(res.forward((int) d));
                    break;
            }
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
