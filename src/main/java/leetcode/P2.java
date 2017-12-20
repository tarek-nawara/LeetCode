package leetcode;

public class P2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
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
                return res.head;
            }
    }
}
