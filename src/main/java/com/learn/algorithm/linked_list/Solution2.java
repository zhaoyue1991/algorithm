package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/9
 * @since 1.0.0
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int total = l1Val + l2Val + carry;
            if (total >= 10) {
                head.next = new ListNode(total % 10);
                carry = 1;
            } else {
                head.next = new ListNode(total);
                carry = 0;
            }
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        return prev.next;
    }

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
}
