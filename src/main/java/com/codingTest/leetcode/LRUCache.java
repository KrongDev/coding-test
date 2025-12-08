package com.codingTest.leetcode;

import java.util.Map;
import java.util.HashMap;

public class LRUCache {
    private final Map<Integer, Node> cacheMap;
    private final Node root, leaf;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.root = new Node(-1, -1);
        this.leaf = new Node(-1, -1);
        this.root.next = this.leaf;
        this.leaf.prev = this.root;
    }

    public int get(int key) {
        Node res = cacheMap.get(key);
        if (res == null) return -1;
        res.cutLink();
        this.root.add(res);
        return res.getVal();
    }

    public void put(int key, int value) {
        Node node;
        if(this.cacheMap.containsKey(key)) {
            node = this.cacheMap.get(key);
            node.cutLink();
            node.setVal(value);
            this.root.add(node);
            return;
        }
        node = this.root.add(key, value);
        cacheMap.put(key, node);
        reBalanceCache();
    }

    private void reBalanceCache() {
        if(this.cacheMap.size() <= this.capacity) return;
        Node removeNode = this.leaf.prev;
        removeNode.cutLink();
        this.cacheMap.remove(removeNode.getKey());
    }

    private static class Node {
        private final int key;
        private int val;
        private Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node add(int key, int val) {
            return this.add(new Node(key, val));
        }

        public Node add(Node node) {
            node.prev = this;
            node.next = this.next;
            node.next.prev = node;
            this.next = node;
            return node;
        }

        public void cutLink() {
            Node prev = this.prev;
            Node next = this.next;

            prev.next = next;
            next.prev = prev;

            this.prev = null;
            this.next = null;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getKey() {
            return this.key;
        }

        public int getVal() {
            return this.val;
        }

        @Override
        public boolean equals(Object obj) {
            return this.key == ((Node)obj).key;
        }
    }
}
