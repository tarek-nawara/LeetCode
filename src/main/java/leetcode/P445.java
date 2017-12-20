package leetcode;

public class P445 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution solver = new Solution();
        final ListNode res = solver.addTwoNumbers(l1, l2);
        System.out.println(res);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            sb.append("[");
            for (; current.next != null; current = current.next) {
                sb.append(current.val).append(", ");
            }
            sb.append(current.val).append("]");
            return sb.toString();
        }
    }

    private static class Solution {
        class ListNodeWrapper {
            ListNode cur;
            ListNode head;

            void append(int val) {
                if (cur == null) {
                    cur = new ListNode(val);
                    head = cur;
                } else {
                    cur.next = new ListNode(val);
                    cur = cur.next;
                }
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int rem = 0;
            l1 = reverse(l1);
            l2 = reverse(l2);
            ListNodeWrapper res = new ListNodeWrapper();
            while (l1 != null && l2 != null) {
                int cur = (l1.val + l2.val + rem) % 10;
                rem = (l1.val + l2.val + rem) / 10;
                res.append(cur);
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int cur = (l1.val + rem) % 10;
                rem = (l1.val + rem) / 10;
                res.append(cur);
                l1 = l1.next;
            }
            while (l2 != null) {
                int cur = (l2.val + rem) % 10;
                rem = (l2.val + rem) / 10;
                res.append(cur);
                l2 = l2.next;
            }
            if (rem != 0) {
                res.append(rem);
            }
            return reverse(res.head);
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode prev = null;
            ListNode cur = head;
            ListNode next = head.next;
            while (next != null) {
                cur.next = prev;
                prev = cur;
                cur = next;
                next = next.next;
            }
            cur.next = prev;
            return cur;
        }
    }

}
