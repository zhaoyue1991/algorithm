package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/10
 * @since 1.0.0
 */
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = size(head);
        int location = k % size;
        if (location == 0) {
            return head;
        }
        ListNode breakNode = findAndBreak(head, size - location);
        ListNode prev = new ListNode(-1);
        prev.next = breakNode;
        while (breakNode.next != null) {
            breakNode = breakNode.next;
        }
        breakNode.next = head;
        return prev.next;
    }

    public int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public ListNode findAndBreak(ListNode head, int location) {
        int temp = 0;
        while (head != null) {
            temp++;
            if (temp == location) {
                ListNode next = head.next;
                head.next = null;
                return next;
            } else {
                head = head.next;
            }

        }
        return null;
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
