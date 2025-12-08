package com.codingTest.leetcode;


import java.util.PriorityQueue;


public class Merge_k_Sorted_Lists {
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            for (ListNode node : lists) {
                if (node != null) {
                    pq.add(node);
                }
            }

            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                current.next = minNode;
                current = current.next;

                if (minNode.next != null) {
                    pq.add(minNode.next);
                }
            }

            return dummy.next;
        }

}
