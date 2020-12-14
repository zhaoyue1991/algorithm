package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/9
 * @since 1.0.0
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode result = prev;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
            head = first.next;
        }
        return result.next;
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