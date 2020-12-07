package com.learn.algorithm.linked_list;

import javax.swing.*;

/**
 * @author zhaoyue23
 * @create 2020/12/7
 * @since 1.0.0
 */
public class Solution206 {

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
