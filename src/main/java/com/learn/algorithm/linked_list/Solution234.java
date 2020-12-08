package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/7
 * @since 1.0.0
 */
public class Solution234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(1);
        System.out.println(isPalindrome(pre));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstEndNode = firstEndNode(head);
        ListNode reverseFirstEndNode = reverseList(firstEndNode.next);
        ListNode p1 = head;
        ListNode p2 = reverseFirstEndNode;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表并返回结果
        firstEndNode.next = reverseList(reverseFirstEndNode);
        foreach(head);
        return true;
    }

    public static void foreach(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    /**
     * 快慢指针、找到需要翻转的节点
     *
     * @param head
     * @return
     */
    public static ListNode firstEndNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
