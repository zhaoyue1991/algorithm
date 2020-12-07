package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/7
 * @since 1.0.0
 */
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstEndNode = firstEndNode(head);
        ListNode reverseFirstEndNode = reverseList(firstEndNode);
        ListNode p1 = head;
        ListNode p2 = reverseFirstEndNode;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    /**
     * 快慢指针、找到需要翻转的节点
     *
     * @param head
     * @return
     */
    public ListNode firstEndNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
