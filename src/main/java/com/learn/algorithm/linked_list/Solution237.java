package com.learn.algorithm.linked_list;

/**
 * @author zhaoyue23
 * @create 2020/12/8
 * @since 1.0.0
 */
public class Solution237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
