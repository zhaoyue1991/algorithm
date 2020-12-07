package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/5
 * @since 1.0.0
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            } else {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return head.next;
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
