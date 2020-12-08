package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/8
 * @since 1.0.0
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        // 哨兵节点
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
