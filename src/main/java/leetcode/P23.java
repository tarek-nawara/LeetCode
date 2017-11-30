package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P23 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(3, new ListNode(8)));
        lists[1] = new ListNode(1, new ListNode(2, new ListNode(4)));
        lists[2] = new ListNode(-1, new ListNode(10));
        final ListNode listNode = solver.mergeKLists(lists);
        System.out.println(listNode);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode current = this;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (current.next != null) {
                sb.append(current.val).append(", ");
                current = current.next;
            }
            sb.append(current.val).append("]");
            return sb.toString();
        }
    }

    private static class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) continue;
                pq.add(lists[i]);
            }
            ListNode res = null;
            ListNode tail = null;
            while (!pq.isEmpty()) {
                final ListNode current = pq.poll();
                ListNode currentNode = new ListNode(current.val);
                if (tail == null) {
                    tail = currentNode;
                    res = currentNode;
                } else {
                    tail.next = currentNode;
                    tail = tail.next;
                }
                if (current.next != null) {
                    pq.add(current.next);
                }
            }
            return res;
        }
    }
}
