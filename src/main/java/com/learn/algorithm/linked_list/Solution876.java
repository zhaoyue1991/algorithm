package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/8
 * @since 1.0.0
 */
public class Solution876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
