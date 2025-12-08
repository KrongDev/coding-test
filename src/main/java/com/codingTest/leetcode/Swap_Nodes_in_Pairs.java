package com.codingTest.leetcode;

public class Swap_Nodes_in_Pairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;
        ListNode prev = head, next;
        prev.next = res.next;
        res.next = prev;
        for (ListNode node = prev.next; node != null; node = node.next) {
            if (node.next == null) break;
            next = node.next;
            node.next = next.next;
            next.next = node;
            prev.next = next;
            prev = node;
        }
        return res;
    }
}
