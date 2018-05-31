package com.learn.data_structure.singleLinkedList;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class Solution19 {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int i = length(head) - n;
    if (i <= 0) {
      return head.next;
    }
    ListNode front = head;
    int index = 0;
    System.out.println(i);
    while (front.next != null && index < i - 1) {
      front = front.next;
      index++;
    }
    if (front.next != null) {
      front.next = front.next.next;
    } else {
      front.next = null;
    }
    return head;
  }

  public int length(ListNode head) {
    int length = 0;
    while (head != null) {
      head = head.next;
      length++;
    }
    return length;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
//    ListNode a = new ListNode(2);
//    ListNode b = new ListNode(3);
//    ListNode c = new ListNode(4);
//    ListNode d = new ListNode(5);
//    head.next = a;
//    a.next = b;
//    b.next = c;
//    c.next = d;
    ListNode result = new Solution19().removeNthFromEnd(head, 1);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
