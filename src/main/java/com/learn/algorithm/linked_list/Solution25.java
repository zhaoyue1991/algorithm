package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2021/4/15
 * @since 1.0.0
 */
public class Solution25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode hair = prev;
        ListNode end = prev;
        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    return hair.next;
                }
                end = end.next;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = reverse(start);
            start.next = next;
            prev = start;
            end = prev;
        }
        return hair.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        ListNode listNode = reverseKGroup(prev.next, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static class ListNode {
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
