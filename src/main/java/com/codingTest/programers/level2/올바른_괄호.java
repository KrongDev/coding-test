package com.codingTest.programers.level2;

public class 올바른_괄호 {

    boolean solution(String s) {

        Node first = null;
        Node last = null;

        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                if(first == null) {
                    first = new Node();
                    last = first;
                    continue;
                }
                last = last.newNextNode();
                continue;
            }
            if(first == null) return false;
            Node prev = last.removeNowNode();
            if(prev == null) {
                first = null;
            }
            last = prev;
        }

        return last == null;
    }

    public static class Node {
        public Node prevNode;
        public Node nextNode;

        public Node() {
        }

        public Node(Node prevNode) {
            this.prevNode = prevNode;
        }

        public static Node from (Node prev) {
            return new Node(prev);
        }

        public Node newNextNode() {
            this.nextNode = Node.from(this);
            return this.nextNode;
        }

        public Node removeNowNode() {
            Node prev = this.prevNode;
            if(prev == null) return null;
            prev.nextNode = null;
            return prev;
        }
    }


    public static void main(String[] args) {
        올바른_괄호 res = new 올바른_괄호();
        System.out.println(res.solution("())()()"));
    }
}
