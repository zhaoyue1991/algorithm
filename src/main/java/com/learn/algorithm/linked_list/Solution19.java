package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/5
 * @since 1.0.0
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        ListNode slow = head;
        ListNode prev = new ListNode(-1);
        prev.next = slow;
        ListNode fast = findFast(head, n);
        if (fast == null) {
            // 删除第一个节点
            prev.next = slow.next;
            return prev.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return prev.next;
    }

    public ListNode findFast(ListNode head, int n) {
        int temp = 0;
        while (head != null) {
            temp++;
            if (temp == n) {
                return head.next;
            } else {
                head = head.next;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
